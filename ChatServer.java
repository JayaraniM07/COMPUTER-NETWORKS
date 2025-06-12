import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for client...");
            Socket s = ss.accept();
            System.out.println("Client connected.");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            String receivedData = "", sendData = "";
            
            while (!receivedData.equals("stop")) {
                receivedData = din.readUTF();
                System.out.println("CLIENT SAYS: " + receivedData);
                System.out.print("TO CLIENT: ");
                sendData = input.nextLine();
                dout.writeUTF(sendData);
            }

            din.close();
            dout.close();
            s.close();
            ss.close();
            input.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}