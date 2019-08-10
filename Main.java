import game.*;
import java.util.ArrayList;

public final class Main {
    
    private Main() {

    }

    public static void main(String[] args) {
        final byte nrPlayers = 5;

        Game test = new Game(nrPlayers);
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < nrPlayers; ++i) {
            players.add(new Player());
        }
        test.startGame(players);
        
        for (Player player : test.getPlayers()) {
            System.out.println(player.getInfo().getGameClass().getValue() + " - " + player.getInfo().getCharacter().getValue() + " " +
                               player.getInfo().getLife() + " " + player.getInfo().getWeapon().getValue() + " " + player.getInfo().getId());
            for (Card card : player.getInfo().getHand()) {
                System.out.println(card);
            }
        }
    }
}
