using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;

namespace Gymme.Repositories.Queries.GetUser
{
    public class GetUserQueryInput : IQueryInput<UserEntity>
    {
        public int UserId { get; set; }

        public GetUserQueryInput(int userId)
        {
            UserId = userId;
        }
    }
}
