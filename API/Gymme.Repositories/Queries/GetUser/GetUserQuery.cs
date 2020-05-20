using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.EntityFramework;
using Gymme.Repositories.Entities;
using System.Threading.Tasks;
using System.Linq;

namespace Gymme.Repositories.Queries.GetUser
{
    class GetUserQuery : IQueryHandler<GetUserQueryInput, UserEntity>
    {
        public async Task<UserEntity> Execute(GetUserQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                return context.UserEntity
                              .Where(s => s.Id == input.UserId)
                              .FirstOrDefault();
            }
        }
    }
}
