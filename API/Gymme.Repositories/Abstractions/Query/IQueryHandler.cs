using System.Threading.Tasks;

namespace Gymme.Repositories.Abstractions.Query
{
    public interface IQueryHandler<QueryType, QueryResultType> where QueryType : IQueryInput<QueryResultType>
    {
        Task<QueryResultType> Execute(QueryType input);
    }
}
