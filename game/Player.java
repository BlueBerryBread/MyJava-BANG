package game;

import enums.*;

import java.net.Socket;

public class Player {
    // conexiune IP
    private Socket connection;
    private PlayerInformation info;

    // test
    public Player() {
    }

    Player(Socket connection) {
        this.connection = connection;
    }

    Player(Classes gameClass, Characters character, Weapons weapon) {
        info = new PlayerInformation(gameClass, character, weapon);
    }

    public void updateInfo(Classes gameClass, Characters character, Weapons weapon) {
        info = new PlayerInformation(gameClass, character, weapon);
    }

    public void updateConnection(Socket connection) {
        this.connection = connection;
    }

    /**
     * @return the connection
     */
    public Socket getConnection() {
        return connection;
    }

    /**
     * @return the info
     */
    public PlayerInformation getInfo() {
        return info;
    }
}