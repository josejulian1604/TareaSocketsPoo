package Client;

import java.net.*;
import java.io.*;
import Common.*;

public class Server implements Runnable{
    ServerSocket server;
    Socket client;
    ObjectInputStream input;
    Dot dot;

    public Server(Dot d) {
        dot = d;
        try {
            server = new ServerSocket(4445);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    public void run(){
        try {
            while(true){
                client = server.accept();
                input = new ObjectInputStream(client.getInputStream());
                Dot newDot = (Dot)input.readObject();
                dot.lastPosition = newDot.lastPosition;
                dot.currentPosition = newDot.currentPosition;
                input.close();
                client.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
