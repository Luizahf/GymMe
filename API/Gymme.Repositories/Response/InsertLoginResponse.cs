using Gymme.Repositories.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Response
{
    public class InsertLoginResponse
    {
        public LoginEntity Login { get; set; }
        public bool Sucess { get; set; }
        public string Message { get; set; }
    }
}
