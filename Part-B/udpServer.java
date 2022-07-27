//First run the udpClient.java file

import java.io.*;
import java.net.*;
import java.util.*;

public class udpServer {
    public static void main(String[] args) throws IOException{
        System.out.println("Server Sender");
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message : ");
        while(true) {
            String msg = sc.nextLine();
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(msg.getBytes() , msg.length() , ip , 3000);
            ds.send(dp);
        }
    }
}