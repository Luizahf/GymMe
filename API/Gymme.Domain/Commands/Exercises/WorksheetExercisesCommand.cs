using Gymme.Repositories.Entities;
using MediatR;
using System.Collections.Generic;

namespace Gymme.Domain.Commands.Exercises
{
    public class WorksheetExercisesCommand : IRequest<List<ExerciseEntity>>
    {
        public int WorksheetId { get; set; }
    }
}
