namespace Gymme.Repositories.Abstractions.Query
{
    public interface IQueryHandler<QueryType, QueryResultType> where QueryType : IQueryInput<QueryResultType>
    {
        QueryResultType Execute(QueryType input);
    }
}
