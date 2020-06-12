using System.Collections.Generic;
using Gymme.Repositories.Base;
using System;

namespace Gymme.Repositories.Entities
{
    public class LoginEntity : EntityBase
    {
        public string Login { get; set; }
        public string Password { get; set; }
        public string ErrorMessage { get; set; }

        public LoginEntity()
        {
        }

        public LoginEntity(string login, string password, string error)
        {
            Login = login;
            Password = password;
            ErrorMessage = error;
        }
        
        internal override IEnumerable<string> CheckIntegrity()
        {
            #region .: Error Strings :.

            const string PASSWORD_WHITESPACE = "A senha não deve conter espaços em branco.";
            const string LOGIN_WHITESPACE = "O login não deve conter espaços em branco.";
            const string PASSWORD_SIZE = "A senha deve conter entre 3 e 10 caracteres.";
            const string LOGIN_SIZE = "O login deve conter entre 5 e 10 caracteres.";
            const string PASSWORD_INEXISTENT = "Senha inválida.";
            const string LOGIN_INEXISTENT = "Login inválido.";

            #endregion

            if (Login.Length > 10 || Login.Length < 5)
                yield return LOGIN_SIZE;

            if (Password.Length > 10 || Password.Length < 3)
                yield return PASSWORD_SIZE;

            if (Password.Contains(" "))
                yield return PASSWORD_WHITESPACE;

            if (Login.Contains(" "))
                yield return LOGIN_WHITESPACE;

            if (string.IsNullOrWhiteSpace(Password))
                yield return PASSWORD_INEXISTENT;

            if (string.IsNullOrWhiteSpace(Login))
                yield return LOGIN_INEXISTENT;
        }
    }
}
