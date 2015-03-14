import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MyReceiver {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		int port = 8777;
		ServerSocket mySocket = new ServerSocket(port);
		TcpReceiver tcpReceiver = new TcpReceiver(mySocket);
		
		while(true)
		tcpReceiver.openServer();
		
	}

}
