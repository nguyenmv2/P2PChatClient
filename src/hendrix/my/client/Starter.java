package hendrix.my.client;

import java.io.IOException;
import java.net.ServerSocket;



public class Starter {
    private static final int DEFAULT_IN_PORT = 8888;
    private static final int DEFAULT_OUT_PORT = 8889;
    

    public static void main (String args[]) throws IOException{
	
	Server handler = new Server(DEFAULT_IN_PORT);
	handler.start();
	TalkerThread talker = new TalkerThread("HelloWorld",s);
	talker.start();
	
    }
}
