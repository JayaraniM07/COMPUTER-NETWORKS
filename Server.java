import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(1309);
            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            // Sample DNS table
            String[] ip = { "165.165.80.80", "165.165.79.1" };
            String[] name = { "www.aptitudeguru.com", "www.downloadcyclone.blogspot.com" };

            System.out.println("Server is running and waiting for requests...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                server.receive(receivePacket);

                String query = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                System.out.println("Received query: " + query);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String result = "Not found";

                for (int i = 0; i < ip.length; i++) {
                    if (query.equalsIgnoreCase(ip[i])) {
                        result = name[i];
                        break;
                    } else if (query.equalsIgnoreCase(name[i])) {
                        result = ip[i];
                        break;
                    }
                }

                sendBuffer = result.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                server.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
