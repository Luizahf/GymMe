using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.Entities;
using System.Collections.Generic;

namespace Gymme.Repositories.Queries.GetUserPractices
{
    public class GetUserPracticesQueryInput : IQueryInput<List<PracticeEntity>>
    {
        public int UserId { get; set; }

        public GetUserPracticesQueryInput(int userId)
        {
            UserId = userId;
        }
    }
}
