using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class PracticeEntity : EntityBase
    {
        public string Description { get; set; }
        public string Goal { get; set; }
        public DateTime? DueDate { get; set; }
        public int? Frequency { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            throw new NotImplementedException();
        }
    }
}
