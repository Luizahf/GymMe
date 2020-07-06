using Gymme.Repositories.Base;
using System.Collections.Generic;

namespace Gymme.Repositories.Entities
{
    public class ExerciseEntity : EntityBase
    {
        public ExerciseEntity(string description)
        {
            Description = description;
        }

        public string Description { get; set; }

        internal override IEnumerable<string> CheckIntegrity()
        {
            #region .: Error Strings :.

            const string Description_Unvalid_Error = "A descrição deve ter entre 5 e 10 caracteres.";

            #endregion

            if (Description.Length > 4 || Description.Length < 11)
                yield return Description_Unvalid_Error;
        }
    }
}
