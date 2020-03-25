using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using MediatR;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.Exercises
{
    internal class WorksheetExercisesHandler : IRequestHandler<WorksheetExercisesCommand, List<ExerciseEntity>>
    {
        private IDataProvider DataProvider { get; }

        public WorksheetExercisesHandler(IDataProvider dataProvider)
        {
            DataProvider = dataProvider;
        }

        Task<List<ExerciseEntity>> IRequestHandler<WorksheetExercisesCommand, List<ExerciseEntity>>.Handle(WorksheetExercisesCommand request, CancellationToken cancellationToken)
        {
            var result = new List<ExerciseEntity>();
            //var oi = DataProvider.GetAll

            //result = DataProvider.GetById<UserEntity>(request.Id);

            return Task.FromResult(result);
        }
    }
}
