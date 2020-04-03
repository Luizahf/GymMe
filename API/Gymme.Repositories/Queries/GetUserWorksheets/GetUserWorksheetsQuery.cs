using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using Gymme.Repositories.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetUserWorksheets
{
    class GetUserWorksheetsQuery : IQueryHandler<GetUserWorksheetsQueryInput, List<WorksheetEntity>>
    {
        public async Task<List<WorksheetEntity>> Execute(GetUserWorksheetsQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                return context.WorksheetEntity
                              .Where(s => s.PracticeId == input.PracticeId)
                              .ToList();
            }
        }
    }
}
