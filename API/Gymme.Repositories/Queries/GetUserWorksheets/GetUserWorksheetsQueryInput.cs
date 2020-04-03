using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Queries.GetUserWorksheets
{
    public class GetUserWorksheetsQueryInput : IQueryInput<List<WorksheetEntity>>
    {
        public int PracticeId { get; set; }

        public GetUserWorksheetsQueryInput(int practiceId)
        {
            PracticeId = practiceId;
        }
    }
}
