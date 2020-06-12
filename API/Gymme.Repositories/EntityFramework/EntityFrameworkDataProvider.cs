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

        public Task<IEnumerable<T>> GetAllAsync<T>() where T : EntityBase =>
            Task.FromResult(Context.Set<T>().AsEnumerable());

        public async Task<EntityValidationResult> InsertAsync<T>(T entity) where T : EntityBase
        {
            var validation = new EntityValidationResult(entity.CheckIntegrity());
            if (validation.IsValid)
            {
                await Context.Set<T>().AddAsync(entity);
                await Context.SaveChangesAsync();
            }

            return validation;
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

        public Task<T> GetByIdAsync<T>(int id) where T : EntityBase => Task.FromResult(Context.Set<T>().Find(id));

        public Task<EntityValidationResult> UpdateAsync<T>(T entity) where T : EntityBase
        {
            throw new NotImplementedException();
        }

        public Task DeleteByIdAsync(int id)
        {
            throw new NotImplementedException();
        }

        #endregion
    }
}
