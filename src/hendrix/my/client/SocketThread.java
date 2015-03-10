package hendrix.my.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread{
    private Socket socket;
    
    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader responses = 
                new BufferedReader
                (new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("Connection open.");
            writer.println("I will echo a single message, then close.");

            StringBuilder sb = new StringBuilder();
            while (!responses.ready()){}
            while (responses.ready()) {
                sb.append(responses.readLine() + '\n');
            }
            System.out.println("From: " + socket.getInetAddress() + ": " + sb);
        
            writer.print(sb);
            writer.flush();
            socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
    }
}
