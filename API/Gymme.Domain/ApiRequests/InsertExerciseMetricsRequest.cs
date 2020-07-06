using Gymme.Repositories.Entities;

namespace Gymme.Domain.ApiRequests
{
    public class InsertExerciseMetricsRequest
    {
        public int ExerciseId { get; set; }
        public int WorksheetId { get; set; }
        public MetricsEntity Metrics { get; set; }
    }
}
