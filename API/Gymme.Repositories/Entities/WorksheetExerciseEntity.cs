using Gymme.Repositories.Base;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class WorksheetExerciseEntity : EntityBase
    {
        public WorksheetExerciseEntity()
        {
        }
        public WorksheetExerciseEntity(int worksheetId, int exerciseId, string exerciseDescription)
        {
            WorksheetId = worksheetId;
            ExerciseId = exerciseId;
            ExerciseDescription = exerciseDescription;
        }

        public int WorksheetId { get; set; }
        public int ExerciseId { get; set; }
        public string ExerciseDescription { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            return new List<string>();
        }
    }
}
