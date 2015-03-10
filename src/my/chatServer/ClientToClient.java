package my.chatServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientToClient implements Runnable {
    Socket clientSocket;
    BufferedReader clientReader;
    PrintWriter clientWriter;
    
    public ClientToClient(Socket clientSock, PrintWriter clientPrintWriter){
	this.clientWriter = clientPrintWriter;
	try {
	    this.clientSocket = clientSock;
	    InputStreamReader inputReader = new InputStreamReader(clientSocket.getInputStream());
	    this.clientReader = new BufferedReader(inputReader);
	} catch (Exception e){
	    System.out.println("ERROR at Client2Client constructor: "+e.toString());
	}
    }
    
    @Override
    public void run() {
	// TODO Auto-generated method stub
	
	try {
	    String stream = clientReader.readLine();
	    while (stream != null){
		System.out.println("stream from another client: "+stream);
		
	    }
	} catch (Exception e) {
	    System.out.println("ERROR at Client2Client: "+e.toString());
	}
    }

}
