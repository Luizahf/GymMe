using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Entities
{
    public class WorksheetExerciseEntity : EntityBase
    {
        public int WorksheetId { get; set; }
        public int ExerciseId { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            return null;
        }
    }
}
