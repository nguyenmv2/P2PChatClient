package my.chatServer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientListener implements Runnable{
    int port;
    public ClientListener(int port) {
	this.port = port;
    }
    @Override
    public void run() {
	// TODO Auto-generated method stub
	ArrayList<PrintWriter> connectedClientWriters = new ArrayList<PrintWriter>();
	ArrayList<String> connectedUsers = new ArrayList<String> ();
	try {
	    ServerSocket serverSock = new ServerSocket(port);
	    while (true){
		Socket clientSocket = serverSock.accept();
		PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream());
		connectedClientWriters.add(clientWriter);
		Thread ClientToClient = new Thread(new ClientToClient(clientSocket, clientWriter));
		ClientToClient.start();
	    }
	} catch (Exception e){
	    System.out.println("ERROR at server: ServerStart -> run "+e.toString());
	}
    }
    
    
}
