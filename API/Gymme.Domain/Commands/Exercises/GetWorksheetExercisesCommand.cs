using Gymme.Repositories.Entities;
using MediatR;
using System.Collections.Generic;

namespace Gymme.Domain.Commands.Exercises
{
    public class GetWorksheetExercisesCommand : IRequest<List<ExerciseEntity>>
    {
        public int WorksheetId { get; set; }
    }
}
