package connection;
import java.net.*;
import java.io.*;

class Client {
    private Socket clientSocket;
    private DataOutputStream outToServer;

    Client(String serverIP, Integer port) throws IOException, UnknownHostException {
        clientSocket = new Socket(serverIP, port);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
    }

    public void sendToServer(String sentence) throws IOException {
        outToServer.writeBytes(sentence);
    }

    public String receiveFromServer() throws IOException {
        BufferedReader inFromServer = new BufferedReader(
                                      new InputStreamReader(clientSocket.getInputStream()));
        return inFromServer.readLine();
    }

    public void closeConnection() throws IOException {
        clientSocket.close();
    }
}
