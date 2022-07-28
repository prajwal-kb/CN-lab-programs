import java.io.*;
import java.net.*;
import java.nio.file.*;

public class prg9tcpServer{
    public static void main(String[] args) throws IOException{
        DataInputStream in;
        DataOutputStream out = null;
        try{
            ServerSocket server = new ServerSocket(6000 , 1);
            System.out.println("Server is waiting for the client ");
            Socket socket = server.accept();
            System.out.println("Client connected");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String filename = in.readUTF();
            System.out.println("file requested is : "+filename);
            byte[] filedata = Files.readAllBytes(Paths.get(filename));
            String filecontent = new String(filedata);
            out.writeUTF(filecontent.toString());
            System.out.println("file sent successfully");
            server.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            out.writeUTF("file doesn't exist");
        }
    }
}