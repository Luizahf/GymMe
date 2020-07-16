using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class WorksheetExerciseMetricsEntity : EntityBase
    {
        public WorksheetExerciseMetricsEntity()
        {
        }

        public WorksheetExerciseMetricsEntity(int worksheetExerciseId, int metricsId, DateTime metricsDate)
        {
            WorksheetExerciseId = worksheetExerciseId;
            MetricsId = metricsId;
            MetricsDate = metricsDate;
        }

        public int WorksheetExerciseId { get; set; }

        public int MetricsId { get; set; }
        public DateTime MetricsDate { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            return new List<string>();
        }
    }
}
