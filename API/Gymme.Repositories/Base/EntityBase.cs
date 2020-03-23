using Gymme.Repositories.Abstractions;
using System.Collections.Generic;

namespace Gymme.Repositories.Base
{
    public abstract class EntityBase : IEntity
    {
        public int Id { get; set; }

        internal abstract IEnumerable<string> CheckIntegrity();
    }
}
