//First run the tcpServer.java file

import java.io.*;
import java.net.*;
import java.util.*;

public class tcpClient {
    public static void main(String[] args) throws IOException{
        DataOutputStream out;
        DataInputStream in;
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost" , 6000);
        System.out.println("Client connected to server ");
        System.out.println("\nEnter the filename to request ");
        String filename = sc.nextLine();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(filename);
        String filecontent = in.readUTF();
        if(filecontent.length() > 0)
            System.out.println(filecontent);
        else
            System.out.println("File is empty");
        sc.close();
        socket.close();
    }
}