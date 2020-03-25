using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System.Collections.Generic;

namespace Gymme.Repositories.Queries.GetWorkSheetExercises
{
    public class GetWorkSheetExercisesQueryInput : IQueryInput<List<WorksheetExerciseEntity>>
    {
        public int WorksheetId { get; set; }
    }
}
