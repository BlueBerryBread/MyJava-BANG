package connection;
import java.net.*;
import java.io.*;

public class Server {
    private ServerSocket socket;
    
    public Server(Integer port) throws IOException {
        socket = new ServerSocket(port);
    }

    // TODO game maybe needs multiplexing (turn-based -> not strictly necessary)
    public void startServer() throws IOException {
        while(true) {
            Socket connectionSocket = socket.accept();
            BufferedReader inFromClient =
            new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            String sentence = inFromClient.readLine();
            // TODO modify game state according to sentence
            // TODO send new game state
            // TODO if game is finished exit loop
            
            outToClient.writeBytes(sentence);
        }
    }
}