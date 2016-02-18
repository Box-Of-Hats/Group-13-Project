/*
 * Contributors: Jiaming Ke
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private final int PORT = 3333;
	private String ip;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Client()
	{
		try
		{
			ip = Inet4Address.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void connectToServer(String ip)
	{
		try
		{
			socket = new Socket(ip, PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
    		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void pushMessageToServer(String string){
		try{
			out.println(string);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String pullMessageFromServer(){
		String string = null;
		try{
			string = in.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		return string;
	}
	
	public void disconnect()
	{
		try
		{
			in.close();
			out.close();
			socket.close();
			System.out.println("Socket is closed.");
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
