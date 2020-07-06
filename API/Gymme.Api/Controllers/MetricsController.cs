using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gymme.Domain.ApiRequests;
using Gymme.Domain.Commands.Metrics;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetExerciseMetrics;
using MediatR;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Gymme.Api.Controllers
{
    [Route("api/metrics")]
    [ApiController]
    public class MetricsController : ControllerBase
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public MetricsController(IDataProvider dataProvider,
                                 IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        [HttpGet("{worksheetId}/exercise/{exerciseId}")]
        public async Task<ActionResult<List<MetricsEntity>>> GetExerciseMetrics(int exerciseId, int worksheetId)
        {
            var query = new GetExerciseMetricsQueryInput(exerciseId, worksheetId);
            var result = await DataProvider.Query(query);
            return Ok(result);
        }

        [HttpPost("insert")]
        public async Task<ActionResult<WorksheetEntity>> InsertExerciseMetrics([FromBody] InsertExerciseMetricsRequest request)
        {
            var result = await Mediator.Send(new InsertExerciseMetricsCommand(request.ExerciseId, request.WorksheetId, request.Metrics));
            return Ok(result);
        }
    }
}