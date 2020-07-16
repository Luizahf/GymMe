using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using Gymme.Repositories.EntityFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gymme.Repositories.Queries.GetExerciseMetrics
{
    public class GetExerciseMetricsQuery : IQueryHandler<GetExerciseMetricsQueryInput, MetricsEntity>
    {
        public async Task<MetricsEntity> Execute(GetExerciseMetricsQueryInput input)
        {
            using (var context = new GymMeContext())
            {
                var worksheetExerciseId = context.WorksheetExerciseEntity
                                                .Where(s => s.WorksheetId == s.WorksheetId && s.ExerciseId == input.ExerciseId)
                                                .Select(s => s.Id).FirstOrDefault();

                var metricsId = context.WorksheetExerciseMetricsEntity
                                        .Where(s => s.WorksheetExerciseId == worksheetExerciseId)
                                        .OrderByDescending(s => s.MetricsDate)
                                        .Select(s => s.MetricsId).FirstOrDefault();

                return context.MetricsEntity
                                .Where(s => s.Id == metricsId).FirstOrDefault();
            }
        }
    }
}
