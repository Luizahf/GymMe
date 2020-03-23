using System.Collections.Generic;
using System.Linq;

namespace Gymme.Repositories.Base
{
    public class EntityValidationResult
    {
        /// <summary>
        /// Identifies if the entity is valid.
        /// </summary>
        public bool IsValid
        {
            get => !ErrorMessages.Any();
        }

        /// <summary>
        /// Descriptions of the error messages if applied.
        /// </summary>
        public IEnumerable<string> ErrorMessages { get; }

        public EntityValidationResult(IEnumerable<string> errorMessages)
        {
            ErrorMessages = errorMessages;
        }
    }
}
