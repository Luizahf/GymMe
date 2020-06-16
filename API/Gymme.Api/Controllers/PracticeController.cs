using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetUserPractices;
using MediatR;
using Microsoft.AspNetCore.Mvc;

namespace Gymme.Api.Controllers
{
    [Route("api/practice")]
    [ApiController]
    public class PracticeController : ControllerBase
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public PracticeController(IDataProvider dataProvider,
                                            IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }

        [HttpGet("{userId}")]
        public async Task<ActionResult<List<PracticeEntity>>> GetUserPractices(int userId)
        {
            var query = new GetUserPracticesQueryInput(userId);
            var result = await DataProvider.Query(query);
            return Ok(result);
        }


        [HttpPost("insert")]
        public async Task<ActionResult<PracticeEntity>> InsertPractice([FromBody] PracticeEntity newPractice)
        {
            var result = await DataProvider.InsertAsync(newPractice);

            if (result.IsValid)
                return Ok(newPractice);

            return BadRequest(result.ErrorMessages);
        }
    }
}