using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using MediatR;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.Users
{
    internal class UserHandler : IRequestHandler<UserCommand, UserEntity>
    {
        private IDataProvider DataProvider { get; }

        public UserHandler(IDataProvider dataProvider)
        {
            DataProvider = dataProvider;
        }

        public Task<UserEntity> Handle(UserCommand request, CancellationToken cancellationToken)
        {
            var result = new UserEntity();

            result = DataProvider.GetById<UserEntity>(request.Id);

            return Task.FromResult(result);
        }
    }
}
