//17003323
// Used for multiple connection addition server
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class AdditionServerThread extends Thread
{
	private int id;
	private static int totalConnections;
	private final int port = 9999;
	
	// declare a "general" socket
	private final Socket connection;
	
	// declare low level and high level objects for input
	private InputStream inStream;
	private DataInputStream inDataStream;
	
	// declare low level and high level objects for output
	private OutputStream outStream;
	private DataOutputStream outDataStream;
	
	// declare other variables
	private String client;
	private String orders;
	private boolean connected;
	
	//stock for items
	private int intPepperoniPizzaStock = 10;
	private int intCheeseBurgerStock = 10;
	private int intGourmetBurgerStock = 10;
	private int intChipsStock = 10;
	private int intPotatoWedgesStock = 10;
	private int intPeriPeriChipsStock = 10;
	private int intWaterStock = 10;
	private int intFantaStock = 10;
	private int intSevenUpStock = 10;
	
	
	public AdditionServerThread(Socket socketIn)
	{
		connection = socketIn;
	}
	
	

	@Override
	public void run()
	{
		try
		{
			connected = true;
			System.out.println("Connection established");
			totalConnections++; // increase the total number of connections
			id = totalConnections; // assign an id
			
			// create an input stream from the client
			inStream = connection.getInputStream();
			inDataStream = new DataInputStream(inStream);
			
			// create an output stream to the client
			outStream = connection.getOutputStream ();
			outDataStream = new DataOutputStream(outStream);
			
			// wait for a string from the client of their address
			client = inDataStream.readUTF();
			System.out.println("Address of client: " + client);
			
			while(connected)
			{
				
				//send integer data about stock of the items
				outDataStream.writeInt(intPepperoniPizzaStock);
				outDataStream.writeInt(intCheeseBurgerStock);
				outDataStream.writeInt(intGourmetBurgerStock);
				
				outDataStream.writeInt(intChipsStock);
				outDataStream.writeInt(intPotatoWedgesStock);
				outDataStream.writeInt(intPeriPeriChipsStock);
				
				outDataStream.writeInt(intWaterStock);
				outDataStream.writeInt(intFantaStock);
				outDataStream.writeInt(intSevenUpStock);
				
				
				
				//recieve integer data about stock of the items to update the stock
				intPepperoniPizzaStock = inDataStream.readInt();
				intCheeseBurgerStock = inDataStream.readInt();
				intGourmetBurgerStock = inDataStream.readInt();
				
				intChipsStock = inDataStream.readInt();
				intPotatoWedgesStock = inDataStream.readInt();
				intPeriPeriChipsStock = inDataStream.readInt();
				
				intWaterStock = inDataStream.readInt();
				intFantaStock = inDataStream.readInt();
				intSevenUpStock = inDataStream.readInt();
				
				
				// Receives a String from the client
				orders = inDataStream.readUTF();
				//output the string to the console
				System.out.println("Order recieved from customer number " + id + ": " + "\n" + orders);
				//send the customer ID to the client
				outDataStream.writeInt(id);
				id = inDataStream.readInt();
			}
		}
		catch(IOException e)
		{
			connected = false;
		}
	}
}
