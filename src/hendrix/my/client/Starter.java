package hendrix.my.client;

import java.io.IOException;
import java.net.ServerSocket;



public class Starter {
    private static final int DEFAULT_IN_PORT = 8888;
    private static final int DEFAULT_OUT_PORT = 8889;
    

    public static void main (String args[]) throws IOException{
	int in_port, out_port;
	
	if (Integer.parseInt(args[0]) == 1){
	    in_port = DEFAULT_IN_PORT;
	    out_port = DEFAULT_OUT_PORT;
	} else {
	    in_port = DEFAULT_OUT_PORT;
	    out_port = DEFAULT_IN_PORT;
	}
	System.out.println(in_port);
	Server handler = new Server(in_port);
	handler.start();
	try {
	    Thread.sleep(10000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	TalkerThread talker = new TalkerThread("HelloWorld","0.0.0.0",out_port);
	talker.start();
    }
}
