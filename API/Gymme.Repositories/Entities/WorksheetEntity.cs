using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Entities
{
    public class WorksheetEntity : EntityBase
    {
        public string Description { get; set; }
        public int PracticeId { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            throw new NotImplementedException();
        }
    }
}
