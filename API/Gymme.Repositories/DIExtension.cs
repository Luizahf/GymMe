using Gymme.Repositories.Abstractions;
using Gymme.Repositories.EntityFramework;
using Microsoft.Extensions.DependencyInjection;

namespace Gymme.Repositories
{
    public static class DIExtension
    {
        public static void InjectRepository(this IServiceCollection services)
        {
            services.AddDbContext<GymMeContext>();
            services.AddScoped<IDataProvider, EntityFrameworkDataProvider>();
        }
    }
}
