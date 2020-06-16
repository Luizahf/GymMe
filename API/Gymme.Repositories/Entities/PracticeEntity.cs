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
        public int UserId { get; set; }

        public PracticeEntity(string description, string goal, DateTime? dueDate, int? frequency, int userId)
        {
            Description = description;
            Goal = goal;
            DueDate = dueDate;
            Frequency = frequency;
            UserId = userId;
        }

        public PracticeEntity() { }

        internal override IEnumerable<string> CheckIntegrity()
        {
            #region .: Error Strings :.
            
            const string Frequency_Unvalid = "A frequência é semanal, por favor insira um número entre 1 e 7.";
            const string Name_Length_Error = "Tamanho do nome do treino inválido. O nome deve ter entre 2 e 44 caracteres.";

            #endregion

            if (Description.Length > 45 || Description.Length < 2)
                yield return Name_Length_Error;

            if (Frequency > 7 || Frequency < 1)
                yield return Frequency_Unvalid;
        }
    }
}
