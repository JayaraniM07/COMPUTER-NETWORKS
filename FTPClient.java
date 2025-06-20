import java.io.*;
import java.net.*;

public class FTPClient {
    public static void main(String[] args) throws Exception {
        InetAddress ia = InetAddress.getLocalHost();
        Socket s = new Socket(ia, 1024);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a new File Name to save received content: ");
        String fname = br.readLine();

        PrintWriter pw = new PrintWriter(new FileWriter(fname));
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while ((line = in.readLine()) != null) {
            pw.println(line);
        }

        pw.close();
        in.close();
        s.close();
    }
}
