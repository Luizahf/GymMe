using Gymme.Domain.ApiRequests;
using Gymme.Domain.Commands;
using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Entities;
using Gymme.Repositories.Queries.GetWorkSheetExercises;
using MediatR;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
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
            var exerciseList = new List<ExerciseEntity>();
            var query = new GetWorkSheetExercisesQueryInput(worksheetId);
            var result = await DataProvider.Query(query);
            result.ForEach(x =>
            {
                exerciseList.Add(new ExerciseEntity(x.ExerciseDescription) { Id = x.Id });

            });
            return Ok(exerciseList);
        }

        [HttpPost("insert")]
        public async Task<ActionResult<WorksheetEntity>> InsertWorksheetExercises([FromBody] InsertWorksheetExercisesRequest request)
        {
            var result = await Mediator.Send(new WorksheetExercisesCommand(request.worksheet, request.exerciseList));
            return Ok(result);
        }
    }
}
