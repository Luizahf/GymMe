using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetWorkSheetExercises
{
    internal class GetWorkSheetExercisesQuery : IQueryHandler<GetWorkSheetExercisesQueryInput, List<WorksheetExerciseEntity>>
    {
        public async Task<List<WorksheetExerciseEntity>> Execute(GetWorkSheetExercisesQueryInput input)
        {
            using (var context = new WorksheetExerciseEntity())
            {
                var query = context.Students
                                   .where(s => s.StudentName == "Bill")
                                   .FirstOrDefault<Student>();
            }

            return new List<WorksheetExerciseEntity>()
            {
                new WorksheetExerciseEntity()
                {}
            };
        }
    }
}
