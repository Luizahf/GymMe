using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using MediatR;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.Users
{
    internal class ExerciseHandler : IRequestHandler<ExerciseCommand, UserEntity>
    {
        private IDataProvider DataProvider { get; }

        public ExerciseHandler(IDataProvider dataProvider)
        {
            DataProvider = dataProvider;
        }

        public Task<UserEntity> Handle(ExerciseCommand request, CancellationToken cancellationToken)
        {
            var result = new UserEntity();

            result = DataProvider.GetById<UserEntity>(request.Id);

            return Task.FromResult(result);
        }
    }
}
