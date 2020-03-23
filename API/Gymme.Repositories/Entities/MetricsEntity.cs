using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class MetricsEntity : EntityBase
    {
        public int Series { get; set; }
        public int Repetitions { get; set; }
        public int Load { get; set; }
        public int ExecutionTime { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            throw new NotImplementedException();
        }
    }
}
