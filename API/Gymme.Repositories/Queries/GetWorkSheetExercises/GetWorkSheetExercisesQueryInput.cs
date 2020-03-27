using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System.Collections.Generic;

namespace Gymme.Repositories.Queries.GetWorkSheetExercises
{
    public class GetWorkSheetExercisesQueryInput : IQueryInput<List<string>>
    {
        public int WorksheetId { get; set; }

        public GetWorkSheetExercisesQueryInput(int worksheetId)
        {
            WorksheetId = worksheetId;
        }
    }
}
