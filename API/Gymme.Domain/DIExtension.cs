using MediatR;
using Microsoft.Extensions.DependencyInjection;

namespace Gymme.Domain
{
    public static class DIExtension
    {
        public static void InjectDomain(this IServiceCollection services)
        {
            var assembly = typeof(DIExtension).Assembly;
            services.AddMediatR(assembly);
        }
    }
}
