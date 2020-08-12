using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using Gymme.Repositories.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetWorkSheetExercises
{
    internal class GetWorkSheetExercisesQuery : IQueryHandler<GetWorkSheetExercisesQueryInput, List<WorksheetExerciseEntity>>
    {
        public async Task<List<WorksheetExerciseEntity>> Execute(GetWorkSheetExercisesQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                return context.WorksheetExerciseEntity
                                          .Where(s => s.WorksheetId == input.WorksheetId).ToList();
            }

        }
    }
}
