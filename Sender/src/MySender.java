import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

public class MySender {

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */

	// TCP Sender
	/*
	 * public static void main(String[] args) throws UnknownHostException,
	 * IOException, InterruptedException {
	 * 
	 * // int port = 8777; // String host = "localhost";
	 * 
	 * int port = 8777; String host = args[0];
	 * 
	 * Socket mySocket = new Socket(host, port); TcpSender tcpSender = new
	 * TcpSender(mySocket); double ete = 0,totalEte = 0,avgEte = 0,maxEte = 0;
	 * int noOfPackets = 1000;
	 * 
	 * for (int i = 1; i <= noOfPackets; i++) {
	 * 
	 * long startTime = System.nanoTime(); tcpSender.send(i); long endTime =
	 * System.nanoTime();
	 * 
	 * ete = (endTime - startTime)/(2*1000000); if (ete > maxEte) { maxEte =
	 * ete; } totalEte += ete;
	 * 
	 * } tcpSender.close(); avgEte = totalEte/noOfPackets;
	 * System.out.println("Total ETE: "+totalEte);
	 * System.out.println("Overall Average ETE: "+avgEte);
	 * System.out.println("Maximum ETE: "+maxEte);
	 * 
	 * }
	 */

	// UPD Sender
	public static void main(String[] args) throws IOException,
			InterruptedException {
		int port = 7777;
		InetAddress host = InetAddress.getLocalHost();
		InetAddress destHost = InetAddress.getByName(args[0]);
		double ete = 0,totalEte = 0,avgEte = 0,maxEte = 0;
		int noOfPackets = 1000;
		
		DatagramSocket mySocket = new DatagramSocket(port, host);
		UdpSender udpSender = new UdpSender(mySocket);

		for (int i = 1; i <= noOfPackets; i++) {
			

			long startTime = System.nanoTime();
			udpSender.send(i, destHost);
			long endTime = System.nanoTime();

			ete = (endTime - startTime) / (2 * 1000);
			if (ete > maxEte) {
				maxEte = ete;
			}
			totalEte += ete;

		}

		udpSender.close();
		mySocket.close(); 
		avgEte = totalEte/noOfPackets;
		System.out.println("Total ETE: "+totalEte);
		System.out.println("Overall Average ETE: "+avgEte);
		System.out.println("Maximum ETE: "+maxEte);
		
	}

}
