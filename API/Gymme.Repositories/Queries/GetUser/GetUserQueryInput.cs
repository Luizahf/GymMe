using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;

namespace Gymme.Repositories.Queries.GetUser
{
    public class GetUserQueryInput : IQueryInput<UserEntity>
    {
        public int LoginId { get; set; }

        public GetUserQueryInput(int loginId)
        {
            LoginId = loginId;
        }
    }
}
