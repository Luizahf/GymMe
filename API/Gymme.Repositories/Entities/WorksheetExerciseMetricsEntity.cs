using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Entities
{
    public class WorksheetExerciseMetricsEntity : EntityBase
    {
        public int WorksheetExerciseId { get; set; }

        public int MetricsId { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            throw new NotImplementedException();
        }
    }
}
