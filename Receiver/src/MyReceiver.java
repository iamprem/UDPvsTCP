import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class MyReceiver {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	/*public static void main(String[] args) throws IOException, InterruptedException {

		int port = 8777;
		ServerSocket mySocket = new ServerSocket(port);
		TcpReceiver tcpReceiver = new TcpReceiver(mySocket);
		
		while(true)
		tcpReceiver.openServer();
		
	}*/

	public static void main(String[] args) throws IOException {
		
		int port = 8777;
		DatagramSocket myDatagramSocket = new DatagramSocket(port);
		UdpReceiver udpReceiver = new UdpReceiver(myDatagramSocket);
		System.out.println("Starting Server... Port: 8777 Host: "+InetAddress.getLocalHost());
		while(true){
			udpReceiver.openServer();
		}
	}
	
}
