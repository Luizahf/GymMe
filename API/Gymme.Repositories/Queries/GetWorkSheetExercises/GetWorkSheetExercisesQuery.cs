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
                var exercisesIds = context.WorksheetExerciseEntity
                                          .Where(s => s.WorksheetId == input.WorksheetId)
                                          .Select(s => s.ExerciseId);

                var result = new List<WorksheetExerciseEntity>();
                
                var exercises = context.ExerciseEntity
                                        .Where(s => exercisesIds.Contains(s.Id))
                                        .ToList();
                exercises.ForEach(ex =>
                {
                    result.Add(new WorksheetExerciseEntity(input.WorksheetId, ex.Id, ex.Description));
                });

                return result;
            }

        }
    }
}
