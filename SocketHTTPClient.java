// File name: SocketHTTPClient.java
import java.io.*;
import java.net.*;

public class SocketHTTPClient {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the website on port 80
            Socket socket = new Socket("www.martinbroadhurst.com", 80);

            // Get the output stream to send HTTP GET request
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            out.println("Host: www.martinbroadhurst.com");
            out.println("Connection: close");
            out.println(); // Blank line to indicate end of request headers

            // Get the input stream to read the server's response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read and print the server's response line by line
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }

            // Close all connections
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}