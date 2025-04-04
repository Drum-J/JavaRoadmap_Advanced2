package chat.server;

import java.io.IOException;

public class ServerMain {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();

        // CommandManager 점진적으로 변경 예정
        CommandManagerV1 commandManagerV1 = new CommandManagerV1(sessionManager);

        Server server = new Server(PORT, commandManagerV1, sessionManager);
        server.start();
    }
}
