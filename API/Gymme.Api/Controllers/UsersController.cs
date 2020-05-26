using System.Threading.Tasks;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetUser;
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
    }
}
 