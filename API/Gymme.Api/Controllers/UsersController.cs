﻿using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Domain.Commands.User;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using MediatR;

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
        [HttpGet("{login}/{password}")]
        public async Task<ActionResult<UserEntity>> GetUser(string login, string password)
        {
            var result = await Mediator.Send(new UserCommand(login, password));
            return Ok(result);
        }

        [HttpGet("insert")]
        public async Task<ActionResult<UserEntity>> InsertUser([FromBody] string name, int? height, int? weight, char? gender, int loginId)
        {
            var newUser = new UserEntity(name, height, weight, gender, loginId);
            var result = await DataProvider.InsertAsync(newUser);

            if (result.IsValid)
                return Ok(newUser);

            return BadRequest(result.ErrorMessages);
        }
    }
}
 