using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Queries.GetExerciseMetrics
{
    public class GetExerciseMetricsQueryInput : IQueryInput<MetricsEntity>
    {
        public int ExerciseId { get; set; }

        public int WorksheetId { get; set; }

        public GetExerciseMetricsQueryInput(int exerciseId, int worksheetId)
        {
            ExerciseId = exerciseId;
            WorksheetId = worksheetId;
        }
    }
}
