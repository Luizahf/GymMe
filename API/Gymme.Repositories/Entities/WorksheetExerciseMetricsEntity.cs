using Gymme.Repositories.Base;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class WorksheetExerciseMetricsEntity : EntityBase
    {
        public WorksheetExerciseMetricsEntity()
        {
        }

        public WorksheetExerciseMetricsEntity(int worksheetExerciseId, int metricsId)
        {
            WorksheetExerciseId = worksheetExerciseId;
            MetricsId = metricsId;
        }

        public int WorksheetExerciseId { get; set; }

        public int MetricsId { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            return new List<string>();
        }
    }
}
