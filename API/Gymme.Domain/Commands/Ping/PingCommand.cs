using MediatR;

namespace Gymme.Domain.Commands.Ping
{
    public class PingCommand : IRequest<string>
    {
        public string Name { get; set; }
    }
}
