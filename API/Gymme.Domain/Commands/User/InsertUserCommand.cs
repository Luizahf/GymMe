using Gymme.Repositories.Entities;
using MediatR;

namespace Gymme.Domain.Commands.User
{
    public class InsertUserCommand : IRequest<UserEntity>
    {
        public InsertUserCommand(string login, string password)
        {
            Login = login;
            Password = password;
        }

        public string Login { get; set; }
        public string Password { get; set; }
    }
}
