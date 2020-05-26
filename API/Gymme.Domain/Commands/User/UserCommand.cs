using Gymme.Repositories.Entities;
using MediatR;

namespace Gymme.Domain.Commands.User
{
    public class UserCommand : IRequest<UserEntity>
    {
        public UserCommand(string login, string password)
        {
            Login = login;
            Password = password;
        }

        public string Login { get; set; }
        public string Password { get; set; }
    }
}
