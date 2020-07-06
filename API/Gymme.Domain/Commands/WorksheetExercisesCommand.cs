using Gymme.Repositories.Entities;
using MediatR;
using System.Collections.Generic;

namespace Gymme.Domain.Commands
{
    public class WorksheetExercisesCommand : IRequest<WorksheetEntity>
    {
        public WorksheetExercisesCommand(WorksheetEntity worksheet, List<ExerciseEntity> exercises)
        {
            Worksheet = worksheet;
            Exercises = exercises;
        }

        public WorksheetEntity Worksheet { get; set; }
        public List<ExerciseEntity> Exercises { get; set; }
    }
}
