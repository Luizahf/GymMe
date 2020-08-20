using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;
using System.Text;

namespace Gymme.Repositories.Entities
{
    public class WorksheetEntity : EntityBase
    {
        public WorksheetEntity(string description, int practiceId)
        {
            Description = description;
            PracticeId = practiceId;
        }

        public string Description { get; set; }
        public int PracticeId { get; set; }

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
