using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using Gymme.Repositories.EntityFramework;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetExercises
{
    public class GetExercisesQuery : IQueryHandler<GetExercisesQueryInput, List<ExerciseEntity>>
    {
        public async Task<List<ExerciseEntity>> Execute(GetExercisesQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                return context.ExerciseEntity
                              .Where(s => input.ExecisesIds.Contains(s.Id))
                              .ToList();
            }
        }
    }
}
