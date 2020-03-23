using MediatR;
using System.Threading;
using System.Threading.Tasks;

namespace Gymme.Domain.Commands.Ping
{
    internal class PingHandler : IRequestHandler<PingCommand, string>
    {
        public Task<string> Handle(PingCommand request, CancellationToken cancellationToken)
        {
            return Task.FromResult("Pong");
        }
    }
}
