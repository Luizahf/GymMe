using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gymme.Repositories.EntityFramework
{
    internal class EntityFrameworkDataProvider : IDataProvider
    {
        GymMeContext Context { get; }

        public EntityFrameworkDataProvider(GymMeContext context)
        {
            Context = context;
        }

        public void DeleteById(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> GetAll<T>() where T : EntityBase => 
            Context.Set<T>().ToList();
  
        public T GetById<T>(int id) where T : EntityBase
        {
            // Estudar os metodos do entity
            return Context.Set<T>().Find(id);
        }

        public EntityValidationResult Insert<T>(T entity) where T : EntityBase
        {
            var validation = new EntityValidationResult(entity.CheckIntegrity());
            if (validation.IsValid)
                Context.Set<T>().Add(entity);

            return validation;
        }

        public Task<T> Query<T>(IQueryInput<T> query)
        {
            throw new NotImplementedException();
        }

        public EntityValidationResult Update<T>(T entity) where T : EntityBase
        {
            throw new NotImplementedException();
        }
    }
}
