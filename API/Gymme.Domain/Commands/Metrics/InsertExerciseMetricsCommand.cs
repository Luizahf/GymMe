using Gymme.Repositories.Entities;
using MediatR;

namespace Gymme.Domain.Commands.Metrics
{
    public class InsertExerciseMetricsCommand : IRequest<WorksheetExerciseMetricsEntity>
    {
        public InsertExerciseMetricsCommand(int exerciseId, int worksheetId, MetricsEntity metrics)
        {
            ExerciseId = exerciseId;
            WorksheetId = worksheetId;
            Metrics = metrics;
        }

        public int ExerciseId { get; set; }
        public int WorksheetId { get; set; }
        public MetricsEntity Metrics { get; set; }
    }
}
