using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.Login;
using MediatR;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gymme.Api.Controllers
{
    [Route("api/login")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private IDataProvider DataProvider { get; }
        private IMediator Mediator { get; }

        public LoginController(IDataProvider dataProvider,
                                IMediator mediator)
        {
            DataProvider = dataProvider;
            Mediator = mediator;
        }
        [HttpGet("{login}/{password}")]
        public async Task<ActionResult<LoginEntity>> GetLogin(string login, string password)
        {
            var query = new GetLoginQueryInput(login, password);
            var result = await DataProvider.Query(query);
            return Ok(result);
        }

        [HttpGet("insert/{login}/{password}")]
        public async Task<ActionResult<LoginEntity>> InsertLogin(string login, string password)
        {
            var newUser = new LoginEntity(login, password, string.Empty);
            var insert = await DataProvider.InsertAsync(newUser);
            
            if (insert.IsValid)
                return Ok(newUser);

            return BadRequest(insert.ErrorMessages);
        }
    }
}

