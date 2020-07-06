using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using MediatR;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.Exercises
{
    internal class GetWorksheetExercisesHandler : IRequestHandler<GetWorksheetExercisesCommand, List<ExerciseEntity>>
    {
        private IDataProvider DataProvider { get; }

        public GetWorksheetExercisesHandler(IDataProvider dataProvider)
        {
            DataProvider = dataProvider;
        }

        Task<List<ExerciseEntity>> IRequestHandler<GetWorksheetExercisesCommand, List<ExerciseEntity>>.Handle(GetWorksheetExercisesCommand request, CancellationToken cancellationToken)
        {
            var result = new List<ExerciseEntity>();
            //var oi = DataProvider.GetAll

            //result = DataProvider.GetById<UserEntity>(request.Id);

            return Task.FromResult(result);
        }
    }
}
