using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetWorkSheetExercises;
using MediatR;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gymme.Api.Controllers
{
    [Route("api/worksheetExercises")]
    [ApiController]
    public class WorksheetExercisesController : ControllerBase
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public WorksheetExercisesController(IDataProvider dataProvider,
                                            IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        [HttpGet("{worksheetId}/exercises")]
        public async Task<ActionResult<List<ExerciseEntity>>> GetWorkSheetExercises(int worksheetId)
        {
            var query = new GetWorkSheetExercisesQueryInput(worksheetId);
            var result = await DataProvider.Query(query);
            return Ok(result);
        }
    }
}
