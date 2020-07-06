using System.Linq;
using System.Threading;
using System.Threading.Tasks;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using MediatR;

namespace Gymme.Domain.Commands
{
    public class WorksheetExercisesHandler : IRequestHandler<WorksheetExercisesCommand, WorksheetEntity>
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public WorksheetExercisesHandler(IDataProvider dataProvider,
                                IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        public async Task<WorksheetEntity> Handle(WorksheetExercisesCommand request, CancellationToken cancellationToken)
        {
            var worksheet = request.Worksheet;
            var exerciseList = request.Exercises;
            await DataProvider.InsertAsync(worksheet);

            var tasks = exerciseList.Select(ex => InserExercises(ex, worksheet));
            var result = await Task.WhenAll(tasks);
            return worksheet;
        }

        private async Task<WorksheetExerciseEntity> InserExercises(ExerciseEntity ex, WorksheetEntity worksheet)
        {
            await DataProvider.InsertAsync(ex);
            await DataProvider.InsertAsync(worksheet);

            var newWorksheetExercises = new WorksheetExerciseEntity(worksheet.Id, ex.Id, ex.Description);
            await DataProvider.InsertAsync(newWorksheetExercises);
            return newWorksheetExercises;
        }
    }
}
