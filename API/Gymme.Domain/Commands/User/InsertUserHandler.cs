using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using MediatR;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.User
{
    public class InsertUserHandler : IRequestHandler<InsertUserCommand, UserEntity>
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public InsertUserHandler(IDataProvider dataProvider,
                                IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        async Task<UserEntity> IRequestHandler<InsertUserCommand, UserEntity>.Handle(InsertUserCommand request, CancellationToken cancellationToken)
        {
            var result = new UserEntity();
            return result;
        }
    }
}
