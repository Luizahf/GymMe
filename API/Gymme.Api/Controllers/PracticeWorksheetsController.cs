using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetUserWorksheets;
using MediatR;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Gymme.Api.Controllers
{
    [Route("api/practiceWorksheets")]
    [ApiController]
    public class PracticeWorksheetsController : ControllerBase
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public PracticeWorksheetsController(IDataProvider dataProvider,
                                            IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        [HttpGet("{practiceId}/worksheets")]
        public async Task<ActionResult<List<WorksheetEntity>>> GetWorkSheetExercises(int practiceId)
        {
            var query = new GetUserWorksheetsQueryInput(practiceId);
            var result = await DataProvider.Query(query);
            return Ok(result);
        }
    }
}