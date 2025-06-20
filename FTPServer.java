import java.io.*;
import java.net.*;

public class FTPServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(1024);
        System.out.println("ServerSocket Generated");

        Socket s = ss.accept();
        System.out.println("ServerSocket Accepted");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream p = new PrintStream(s.getOutputStream());

        System.out.print("Enter a File Name: ");
        String fname = br.readLine();
        File f1 = new File(fname);

        if (f1.exists()) {
            BufferedReader fr = new BufferedReader(new FileReader(f1));
            String line;
            while ((line = fr.readLine()) != null) {
                p.println(line);
            }
            fr.close();
        } else {
            p.println("File not found!");
        }

        p.close();
        s.close();
        ss.close();
    }
}
