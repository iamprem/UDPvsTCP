import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UdpReceiver {

	private DatagramSocket udpServeSocket;

	public UdpReceiver(DatagramSocket udpServeSocket) {
		super();
		this.udpServeSocket = udpServeSocket;
	}
	
	void openServer() throws IOException{
		//UPD is not connection oriented. So it will not make connection with the client
		//without handshaking it start receiving data
		receive();
		return;
	}
	
	void receive() throws IOException{
		
		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		udpServeSocket.receive(receivePacket);
//		String receivedDataFeild = new String(receivePacket.getData(),"UTF-8");
//		System.out.println(receivedDataFeild);
		byte[] sendData = receivePacket.getData();
		udpServeSocket.send(new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort()));
		return;
	}
}
