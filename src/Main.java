import java.io.IOException;

public class Main
{
    public static void main(String[] args)
            throws IOException
    {
        if (args.length > 0)
            usage();

        Server server = new Server();
        server.go();
    }

    static void usage()
    {
        System.err.println("usage: server");
        System.exit(1);
    }
}
