import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.sound.midi.Receiver;

public class UdpSender {

	private DatagramSocket udpSocket;
	private String udpPacket;

	public UdpSender(DatagramSocket udpSocket) {
		super();
		this.udpSocket = udpSocket;
	}

	void send(int seqNumber, InetAddress destHost) throws IOException,
			InterruptedException {

		String dataFeild = constructMessage();
		udpPacket = seqNumber + "@" + dataFeild;
//		System.out.println(new String(udpPacket.getBytes(), "UTF-8"));
		byte[] sendData = udpPacket.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, destHost, 8777);
		udpSocket.send(sendPacket);
		
		byte[] receiveData = new byte[sendData.length];
		DatagramPacket receivePacket = new DatagramPacket(receiveData , receiveData.length);
		udpSocket.receive(receivePacket);
//		System.out.println(new String(receivePacket.getData(),"UTF-8"));
		return;
	}

	void close() throws IOException {

		udpSocket.close();
	}

	private String constructMessage() {
		int lengthOfMessage = 10;
		String message = "";
		for (int i = 0; i < lengthOfMessage; i++) {
			message += "C";
		}
		return message;

	}
}
