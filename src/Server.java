import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    final int PORT = 8888;

    public void go()
            throws IOException
    {
        System.out.println("Starting server");
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            ServerWorker worker = new ServerWorker(socket, 128,128);
            worker.start();
        }
    }
}
