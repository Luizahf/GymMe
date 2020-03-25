using Gymme.Repositories.Entities;
using MediatR;

namespace Gymme.Domain.Commands.Users
{
    public class ExerciseCommand : IRequest<UserEntity>
    {
        public int Id { get; set; }
    }
}
