using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class ExerciseEntity : EntityBase
    {
        public string Description { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            throw new NotImplementedException();
        }
    }
}
