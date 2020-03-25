using Gymme.Repositories.Abstractions;
using Gymme.Repositories.Abstractions.Query;
using Gymme.Repositories.EntityFramework;
using Microsoft.Extensions.DependencyInjection;
using System.Linq;

namespace Gymme.Repositories
{
    public static class DIExtension
    {
        public static void InjectRepository(this IServiceCollection services)
        {
            services.AddDbContext<GymMeContext>();
            services.AddScoped<IDataProvider, EntityFrameworkDataProvider>();

            InjectQueries(services);
        }

        private static void InjectQueries(IServiceCollection services)
        {
            var assembly = typeof(DIExtension).Assembly;
            var queryHandler = assembly.GetTypes().Where(w => w.IsAssignableFrom(typeof(IQueryHandler<,>)));
            foreach (var queryType in queryHandler)
                foreach (var queryTypeInterface in queryType.GetInterfaces())
                    services.AddTransient(queryTypeInterface, queryType);
        }
    }
}
