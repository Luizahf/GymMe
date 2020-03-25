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
            
            var queryInterface = typeof(IQueryHandler<,>);
            
            var queryDI = assembly.GetTypes()
                                  .Select(s => new
                                  {
                                      Implementation = s,
                                      Services = s.GetInterfaces()
                                                  .Where(w => w.IsGenericType
                                                           && w.GetGenericTypeDefinition() == queryInterface)
                                  })
                                  .Where(w => w.Services.Any());

            foreach (var dependecy in queryDI)
                foreach (var serviceType in dependecy.Services)
                    services.AddTransient(serviceType, dependecy.Implementation);
        }
    }
}
