import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter domain name or IP address: ");
            String input = reader.readLine();

            sendBuffer = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 1309);
            client.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            client.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Response from server: " + response);

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
