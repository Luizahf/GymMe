using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using Gymme.Repositories.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetUserPractices
{
    class GetUserPracticesQuery : IQueryHandler<GetUserPracticesQueryInput, List<PracticeEntity>>
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
