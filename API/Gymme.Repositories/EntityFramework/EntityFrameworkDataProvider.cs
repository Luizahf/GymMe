using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Gymme.Repositories.EntityFramework
{
    internal class EntityFrameworkDataProvider : IDataProvider
    {
        GymMeContext Context { get; }
        IServiceProvider ServiceLocator { get; }

        public EntityFrameworkDataProvider(GymMeContext context, IServiceProvider serviceLocator)
        {
            Context = context;
            ServiceLocator = serviceLocator;
        }

        public void DeleteById(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> GetAll<T>() where T : EntityBase =>
            Context.Set<T>().ToList();

        public T GetById<T>(int id) where T : EntityBase
        {
            return Context.Set<T>().Find(id);
        }

        public EntityValidationResult Insert<T>(T entity) where T : EntityBase
        {
            var validation = new EntityValidationResult(entity.CheckIntegrity());
            if (validation.IsValid)
                Context.Set<T>().Add(entity);

            return validation;
        }

        public EntityValidationResult Update<T>(T entity) where T : EntityBase
        {
            throw new NotImplementedException();
        }

        public async Task<TOutput> Query<TOutput>(IQueryInput<TOutput> query)
        {
            const string QueryHandlerMethod = "Execute";

            if (TryGetQueryHandler(query, out object handler))
            {
                var handerType = handler.GetType();
                
                var queryMethod = handerType.GetMethod(QueryHandlerMethod);
                
                return await (Task<TOutput>)queryMethod.Invoke(handler, new object[] { query });
            }

            return default;
        }

        #region .:: Get Handler Reflection ::.
        
        private static Type QueryHandlerType = typeof(IQueryHandler<,>);

        private bool TryGetQueryHandler<TOutput>(IQueryInput<TOutput> query, out object handler)
        {
            handler = null;
            
            var queryOutputType = typeof(TOutput);
            
            var queryInputType = query.GetType();
            
            handler = ServiceLocator.GetService(QueryHandlerType.MakeGenericType(queryInputType, queryOutputType));
            return handler != null;
        }

        #endregion
    }
}
