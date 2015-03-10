package hendrix.my.client;

public class Message {
    String host;
    int port;
    String message;
    boolean isGroupMessage;
    
    public Message(String h, int p, String m, boolean i){
	host = h;
	port = p;
	message = m;
	isGroupMessage = i;
    }
}
