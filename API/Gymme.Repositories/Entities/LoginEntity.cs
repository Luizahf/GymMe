using System.Collections.Generic;
using Gymme.Repositories.Base;
using System;

namespace Gymme.Repositories.Entities
{
    public class LoginEntity : EntityBase
    {
        public int IdUser { get; set; }
        public string Login { get; set; }
        public string Password { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            throw new NotImplementedException();
        }
    }
}
