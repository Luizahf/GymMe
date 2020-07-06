using Gymme.Repositories.Entities;
using System.Collections.Generic;

namespace Gymme.Domain.ApiRequests
{
    public class InsertWorksheetExercisesRequest
    {
        public WorksheetEntity worksheet { get; set; }
        public List<ExerciseEntity> exerciseList { get; set; }
    }
}
