using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
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
    }
}