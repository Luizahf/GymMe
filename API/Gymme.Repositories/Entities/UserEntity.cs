using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class UserEntity : EntityBase
    {
        public string Name { get; set; }
        public int? Height { get; set; }
        public int? Weight { get; set; }
        public Char? Gender { get; set; }
        public int LoginId { get; set; }

        public UserEntity()
        {
        }

        public UserEntity(string name, int? height, int? weight, char? gender, int loginId)
        {
            Name = name;
            Height = height;
            Weight = weight;
            Gender = gender;
            LoginId = loginId;
        }

        internal override IEnumerable<string> CheckIntegrity()
        {
            #region .: Error Strings :.

            const string Gender_Unvalid_Error = "Gênero inválido.";
            const string Height_Unvalid = "Altura inválida. A altura deve ser menor que 280cm.";
            const string Weight_Unvalid = "Peso inválido. O peso não deve ser entre 20Kg e 500Kg.";
            const string Name_Length_Error = "Tamanho do nome inválido. O nome deve ter entre 1 e 45 caracteres.";

            #endregion

            if (Name.Length > 45 || Name.Length < 2)
                yield return Name_Length_Error;

            if (Gender.HasValue && Gender != 'F' && Gender != 'M')
                yield return Gender_Unvalid_Error;

            if (Height > 280)
                yield return Height_Unvalid;

            if (Weight < 20 || Weight > 500)
                yield return Weight_Unvalid;
        }
    }
}
