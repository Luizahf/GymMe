using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetWorkSheetExercises;
using Gymme.Repositories.Queries.GetExercises;
using MediatR;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.Exercises
{
    internal class GetWorksheetExercisesHandler : IRequestHandler<GetWorksheetExercisesCommand, List<ExerciseEntity>>
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public GetWorksheetExercisesHandler(IDataProvider dataProvider, IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        public async Task<List<ExerciseEntity>> Handle(GetWorksheetExercisesCommand request, CancellationToken cancellationToken)
        {
            var getWorksheetExercises = new GetWorkSheetExercisesQueryInput(request.WorksheetId);
            var worksheetExercises = await DataProvider.Query(getWorksheetExercises);

            var getExercises = new GetExercisesQueryInput(worksheetExercises.Select(we => we.ExerciseId).ToList());
            var exercises = await DataProvider.Query(getExercises);

            return exercises.ToList();
        }
    }
}
