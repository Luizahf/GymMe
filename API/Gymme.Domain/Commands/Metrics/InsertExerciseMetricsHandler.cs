using Gymme.Repositories.Queries.GetWorkSheetExercises;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using System.Threading.Tasks;
using System.Threading;
using System.Linq;
using MediatR;
using Gymme.Repositories.Queries.GetExerciseMetrics;

namespace Gymme.Domain.Commands.Metrics
{
    public class InsertExerciseMetricsHandler : IRequestHandler<InsertExerciseMetricsCommand, WorksheetExerciseMetricsEntity>
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public InsertExerciseMetricsHandler(IDataProvider dataProvider,
                                            IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        public async Task<WorksheetExerciseMetricsEntity> Handle(InsertExerciseMetricsCommand request, CancellationToken cancellationToken)
        {
            var result = new WorksheetExerciseMetricsEntity();
            var metrics = request.Metrics;

            var getWorksheetExercises = new GetWorkSheetExercisesQueryInput(request.WorksheetId);
            var worksheetExercises = await DataProvider.Query(getWorksheetExercises);
            
            var newMetrics = new MetricsEntity(request.Metrics.Series, request.Metrics.Repetitions, request.Metrics.Load, request.Metrics.ExecutionTime);
            var insertNewMetrics = await DataProvider.InsertAsync(newMetrics);
            
            var newWorksheetExerciseMetrics = new WorksheetExerciseMetricsEntity(worksheetExercises
                                                .Where(we => we.ExerciseId == request.ExerciseId).FirstOrDefault().Id, newMetrics.Id);
            var insertNewWorksheetExerciseMetrics  = await DataProvider.InsertAsync(newWorksheetExerciseMetrics);
            
            var getWorksheetExerciseMetrics = new GetExerciseMetricsQueryInput(request.ExerciseId, request.WorksheetId);
            var worksheetExerciseMetrics = await DataProvider.Query(getWorksheetExerciseMetrics);

            result.WorksheetExerciseId = worksheetExerciseMetrics.Id;
            result.MetricsId = worksheetExerciseMetrics.Id;
            return result;
        }
    }
}
