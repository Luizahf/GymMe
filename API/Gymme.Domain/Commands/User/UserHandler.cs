using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading;
using MediatR;
using Gymme.Repositories.Queries.Login;
using Gymme.Repositories.Queries.GetUser;

namespace Gymme.Domain.Commands.User
{
    internal class UserHandler : IRequestHandler<UserCommand, UserEntity>
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public UserHandler(IDataProvider dataProvider,
                                IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        async Task<UserEntity> IRequestHandler<UserCommand, UserEntity>.Handle(UserCommand request, CancellationToken cancellationToken)
        {
            var result = new UserEntity();

            var loginQuery = new GetLoginQueryInput(request.Login, request.Password);
            var loginResult = await DataProvider.Query(loginQuery);

            if (loginResult != null)
            {
                var userQuery = new GetUserQueryInput(loginResult.IdUser);
                result = await DataProvider.Query(userQuery);

            }

            return result;
        }
    }
}
