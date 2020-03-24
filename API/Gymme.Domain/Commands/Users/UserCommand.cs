using Gymme.Repositories.Entities;
using MediatR;

namespace Gymme.Domain.Commands.Users
{
    public class UserCommand : IRequest<UserEntity>
    {
        public int Id { get; set; }
    }
}
