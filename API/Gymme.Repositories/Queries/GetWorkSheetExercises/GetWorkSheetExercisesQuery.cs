using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using Gymme.Repositories.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetWorkSheetExercises
{
    internal class GetWorkSheetExercisesQuery : IQueryHandler<GetWorkSheetExercisesQueryInput, List<string>>
    {
        public async Task<List<string>> Execute(GetWorkSheetExercisesQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                var exercisesIds = context.WorksheetExerciseEntity
                                          .Where(s => s.WorksheetId == input.WorksheetId)
                                          .Select(s => s.ExerciseId);

                return context.ExerciseEntity
                              .Where(s => exercisesIds.Contains(s.Id))
                              .Select(s => s.Description)
                              .ToList();
            }

        }
    }
}
