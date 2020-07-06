using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class MetricsEntity : EntityBase
    {
        public MetricsEntity()
        {
        }

        public MetricsEntity(int? series, int? repetitions, int? load, int? executionTime)
        {
            Series = series;
            Repetitions = repetitions;
            Load = load;
            ExecutionTime = executionTime;
        }

        public int? Series { get; set; }
        public int? Repetitions { get; set; }
        public int? Load { get; set; }
        public int? ExecutionTime { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            return new List<string>();
        }
    }
}
