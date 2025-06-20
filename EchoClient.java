import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);
            System.out.println("Connected to Server.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);

            
            String sendData = "", receivedData = "";

            while (!sendData.equals("stop")) {
                System.out.print("TO SERVER: ");
                sendData = input.nextLine();
                dout.writeUTF(sendData);

                receivedData = din.readUTF();
                System.out.println("SERVER SAYS: " + receivedData);
            }

            din.close();
            dout.close();
            s.close();
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
