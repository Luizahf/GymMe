using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;

namespace Gymme.Repositories.Queries.Login
{
    public class GetLoginQueryInput : IQueryInput<LoginEntity>
    {
        public string Login { get; set; }
        public string Password { get; set; }

        public GetLoginQueryInput(string login, string password)
        {
            Login = login;
            Password = password;
        }
    }
}
