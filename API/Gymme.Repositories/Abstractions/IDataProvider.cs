using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Base;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Gymme.Repositories.Abstractions
{
    /// <summary>
    /// Provides access to data.
    /// </summary>
    public interface IDataProvider
    {
        /// <summary>
        /// Provides the entity from the database based on it's id.
        /// </summary>
        /// <typeparam name="T">Generic entity type</typeparam>
        T GetById<T>(int id) where T : EntityBase;

        /// <summary>
        /// Provides all objects from a source.
        /// </summary>
        IEnumerable<T> GetAll<T>() where T : EntityBase;

        /// <summary>
        /// Inserts a new object in the source.
        /// </summary>
        EntityValidationResult Insert<T>(T entity) where T : EntityBase;

        /// <summary>
        /// Updates an object in the source.
        /// </summary>
        EntityValidationResult Update<T>(T entity) where T : EntityBase;

        /// <summary>
        /// Deletes an object from a source based on it's id;
        /// </summary>
        void DeleteById(int id);

        /// <summary>
        /// Executes given query at the source.
        /// </summary>
        Task<T> Query<T>(IQueryInput<T> query);
    }
}
