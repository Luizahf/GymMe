using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gymme.Domain.Commands.Ping;
using Gymme.Domain.Commands.Users;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetUser;
using Gymme.Repositories.Queries.GetWorkSheetExercises;
using MediatR;
using Microsoft.AspNetCore.Mvc;

namespace Gymme.Api.Controllers
{
    [Route("api/users")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public UsersController(IDataProvider dataProvider,
                                IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }
        [HttpGet("{userId}")]
        public async Task<ActionResult<UserEntity>> GetUser(int userId)
        {
            var query = new GetUserQueryInput(userId);
            var result = await DataProvider.Query(query);
            return Ok(result);
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
