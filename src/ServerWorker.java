import java.io.*;
import java.net.Socket;

public class ServerWorker extends Thread
{
    Socket socket;
    InputStream input;
    OutputStream output;
    byte[] incoming, outgoing;
    int incomingLen;
    int outgoingLen;

    public ServerWorker(Socket socket, int incomingLen, int outgoingLen)
            throws IOException
    {
        this.socket = socket;
        socket.setTcpNoDelay(true);
        input = socket.getInputStream();
        output = socket.getOutputStream();
        this.incomingLen = incomingLen;
        this.outgoingLen = outgoingLen;
        incoming = new byte[incomingLen];
        outgoing = new byte[outgoingLen];
    }

    public void run()
    {
        try {
            while (true) {
                int read = input.readNBytes(incoming, 0, incomingLen);
                if (read < incomingLen)
                    return;
                output.write(outgoing, 0, outgoingLen);
            }
        } catch (IOException e) {
            System.err.println("Exception: " + e);
            return;
        }
    }
}
