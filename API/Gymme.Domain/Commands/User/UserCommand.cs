using Gymme.Repositories.Entities;
using System.Collections.Generic;
using MediatR;

namespace Gymme.Domain.Commands.User
{
    public class UserCommand : IRequest<UserEntity>
    {
        public string Login { get; set; }
        public string Password { get; set; }
    }
}
