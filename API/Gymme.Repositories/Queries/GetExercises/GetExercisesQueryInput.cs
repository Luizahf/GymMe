using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System.Collections.Generic;

namespace Gymme.Repositories.Queries.GetExercises
{
    public class GetExercisesQueryInput : IQueryInput<List<ExerciseEntity>>
    {
        public List<int> ExecisesIds { get; set; }

        public GetExercisesQueryInput(List<int> execisesIds)
        {
            ExecisesIds = execisesIds;
        }
    }
}
