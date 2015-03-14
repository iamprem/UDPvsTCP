import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpReceiver {


	private ServerSocket serverSocket;
	private String receivedTcpDataFeild;
	private Socket serveClient;
	BufferedReader reader;
	PrintWriter writer;
	
	public TcpReceiver(ServerSocket serverSocket) {
		super();
		this.serverSocket = serverSocket;
	}
	
	public void openServer() throws IOException, InterruptedException{
		
		serveClient = new Socket();
		System.out.println("Waiting for incomming connection...");
		System.out.println("========================================");
		serveClient = serverSocket.accept();
		writer = new PrintWriter(serveClient.getOutputStream(),true);
		reader = new BufferedReader(new InputStreamReader(serveClient.getInputStream()));
		System.out.println("The following client has connected:"
				+ serveClient.getInetAddress().getCanonicalHostName());
		
		System.out.println("Open to Receive data");
		System.out.println("========================================");
		receive(serveClient);
		System.out.println("Closing server");
		System.out.println("========================================");
		serveClient.close();
		return;
	}
	
	
	private void receive(Socket serveClient) throws IOException, InterruptedException{
		
		String receivedTcpPacket;
		while ((receivedTcpPacket = reader.readLine()) != null) {
			receivedTcpDataFeild += receivedTcpPacket.split("@")[1];
			writer.println(receivedTcpPacket.split("@")[1]);
		}
		
		writer.close();
		reader.close();
		return;
		
	}
	
}
