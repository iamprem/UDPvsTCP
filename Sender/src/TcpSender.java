import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpSender {

	private Socket socket;
	private String tcpPacket;

	public TcpSender(Socket socket) {
		super();
		this.socket = socket;
		System.out.println("Connection established!");
		System.out.println("=============================");
	}

	void send(int seqNumber) throws IOException, InterruptedException {

		String dataFeild = constructMessage();
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));

		tcpPacket = seqNumber + "@" + dataFeild;
		writer.println(tcpPacket);
		String tcpReturnPacket = reader.readLine();
//		if (!tcpReturnPacket.equals(dataFeild)) {
//			socket.close();
//		}
		return;
	}
	
	void close() throws IOException{
		
		socket.close();
	}

	private String constructMessage() {
		int lengthOfMessage = 200;
		String message = "";
		for (int i = 0; i < lengthOfMessage; i++) {
			message += "C";
		}
		return message;
		
	}

}
