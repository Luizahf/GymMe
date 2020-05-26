using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.EntityFramework;
using Gymme.Repositories.Entities;
using System.Threading.Tasks;
using System.Linq;

namespace Gymme.Repositories.Queries.Login
{
    class GetLoginQuery : IQueryHandler<GetLoginQueryInput, LoginEntity>
    {
        public async Task<LoginEntity> Execute(GetLoginQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                return context.LoginEntity
                              .Where(s => s.Login == input.Login && s.Password == input.Password)
                              .FirstOrDefault();
            }
        }
    }
}
