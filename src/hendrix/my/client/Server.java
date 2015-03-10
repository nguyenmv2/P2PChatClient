package hendrix.my.client;


import java.net.*;
import java.io.*;

public class Server extends Thread{
	private ServerSocket accepter;

	public Server(int port) throws IOException {
		accepter = new ServerSocket(port);
		System.out.println("Server IP address: " + accepter.getInetAddress());
	}
	@Override
	public void run(){
	    try {
		listen();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	public void listen() throws IOException {
		for (;;) {
			Socket s = accepter.accept();
			SocketThread echoer = new SocketThread(s);
			System.out.println("Connection accepted from " + s.getInetAddress());
			echoer.start();
		}
	}

	public static void main(String[] args) throws IOException {
		Server s = new Server(Integer.parseInt(args[0]));
		s.listen();
	}
}


