//17003323
// Multiple Connection Addition Server
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
public class Server
{
	public static void main(String[] args)
	{
		final int port = 9999;
		AdditionServerThread thread;
		Socket socket;
		System.out.println("Listening for connections on port: " + port);
		try
		{
			ServerSocket listenSocket = new ServerSocket(port);
			while(true) // continuously listen for connections
			{
				socket = listenSocket.accept();
				thread = new AdditionServerThread(socket);
				thread.start();
			}
		}
		catch(IOException e)
		{
		}
	}
}