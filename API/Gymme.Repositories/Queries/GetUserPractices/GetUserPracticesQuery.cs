using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.EntityFramework;
using Gymme.Repositories.Entities;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Linq;

namespace Gymme.Repositories.Queries.GetUserPractices
{
    class GetUserWorksheetsQuery : IQueryHandler<GetUserPracticesQueryInput, List<PracticeEntity>>
    {
        public async Task<List<PracticeEntity>> Execute(GetUserPracticesQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                return context.PracticeEntity
                              .Where(s => s.UserId == input.UserId)
                              .ToList();
            }
        }
    }
}
