package game;

import enums.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Game {
    private Integer gameSeed;
    private boolean started;
    private byte nrOfPlayers;
    private ArrayList<Player> players;
    private ArrayList<Classes> classes;
    private ArrayList<Characters> characters;
    private ArrayList<Card> deck;
    private ArrayList<Card> discardedDeck;
    private final byte nrOfCards = 80;
    private byte playerTurn;

    public Game(byte nrOfPlayers) throws IllegalArgumentException {
        this.nrOfPlayers = nrOfPlayers;
        this.started = false;

        // Generat clase + random
        classes = new ArrayList<Classes>();
        classes.addAll(Arrays.asList(Classes.SHER, Classes.RENE, 
                                    Classes.OUTL, Classes.OUTL));
        switch (nrOfPlayers) {
            case 4: break;
            case 5: classes.add(Classes.DEPU);
                    break;
            case 6: classes.add(Classes.OUTL);
                    break;
            case 7: classes.add(Classes.DEPU);
                    break;
            default: throw new IllegalArgumentException("Invalid number of players!");
        }
        gameSeed = Generator.generateGameSeed(); // afisat
        Collections.shuffle(classes, Generator.getGenerator());

        // Generat caractere + random
        characters = new ArrayList<Characters>();
        characters.addAll(Arrays.asList(Characters.PAUL, Characters.JOUR, Characters.BLAC, 
                                        Characters.SLAB, Characters.ELGR, Characters.JESS, 
                                        Characters.SUZY, Characters.WILL, Characters.ROSE, 
                                        Characters.BART, Characters.PEDR, Characters.SIDK, 
                                        Characters.LUCK, Characters.VULT, Characters.CALA, 
                                        Characters.KITC));
        Collections.shuffle(characters, Generator.getGenerator());

        // Generat deck + random ♠ ♥ ♦ ♣
        deck = new ArrayList<Card>(nrOfCards);
        discardedDeck = new ArrayList<Card>(nrOfCards);
        createDeck(deck);
        Collections.shuffle(deck, Generator.getGenerator());
    }
    
    private void createDeck(ArrayList<Card> deck) {
        deck.addAll(Arrays.asList(Weapons.SCHO.updateWeapons(12, '♣'), Weapons.SCHO.updateWeapons(13, '♣'), 
                                  Weapons.REMI.updateWeapons(14, '♣'), Weapons.SCHO.updateWeapons(14, '♠'), 
                                  Weapons.WINC.updateWeapons(8, '♠'), Weapons.CARA.updateWeapons(1, '♣'),
                                  Weapons.VOLC.updateWeapons(10, '♠'), Weapons.VOLC.updateWeapons(10, '♣')));
                                  
        deck.addAll(Arrays.asList(PermanentCards.JAIL.updatePermanentCards(10, '♠'),
                                  PermanentCards.JAIL.updatePermanentCards(12, '♠'), 
                                  PermanentCards.JAIL.updatePermanentCards(4, '♥'),
                                  PermanentCards.DYNA.updatePermanentCards(2, '♥'), 
                                  PermanentCards.SCOP.updatePermanentCards(1, '♠'),
                                  PermanentCards.MUST.updatePermanentCards(8, '♥'), 
                                  PermanentCards.MUST.updatePermanentCards(9, '♥'),
                                  PermanentCards.BARR.updatePermanentCards(13, '♠'),
                                  PermanentCards.BARR.updatePermanentCards(14, '♠')));

        for (int cardNumber = 2; cardNumber < 10; ++cardNumber) {
            deck.add(PlayingCards.BANG.updatePlayingCards(cardNumber, '♣'));
        }
        for (int cardNumber = 1; cardNumber < 15; ++cardNumber) {
            if (cardNumber == 11) continue;
            deck.add(PlayingCards.BANG.updatePlayingCards(cardNumber, '♦'));
        }
        deck.add(PlayingCards.BANG.updatePlayingCards(13, '♥'));
        deck.add(PlayingCards.BANG.updatePlayingCards(14, '♥'));
        deck.add(PlayingCards.BANG.updatePlayingCards(1, '♥'));
        deck.add(PlayingCards.BANG.updatePlayingCards(1, '♠'));

        for (int cardNumber = 2; cardNumber < 9; ++cardNumber) {
            deck.add(PlayingCards.MISS.updatePlayingCards(cardNumber, '♠'));
        }
        deck.add(PlayingCards.MISS.updatePlayingCards(10, '♣'));
        deck.add(PlayingCards.MISS.updatePlayingCards(12, '♣'));
        deck.add(PlayingCards.MISS.updatePlayingCards(13, '♣'));
        deck.add(PlayingCards.MISS.updatePlayingCards(14, '♣'));
        deck.add(PlayingCards.MISS.updatePlayingCards(1, '♣'));

        for (int cardNumber = 6; cardNumber < 13; ++cardNumber) {
            if (cardNumber == 11) continue;
            deck.add(PlayingCards.BEER.updatePlayingCards(cardNumber, '♥'));
        }

        deck.add(PlayingCards.PANI.updatePlayingCards(12, '♥'));
        deck.add(PlayingCards.PANI.updatePlayingCards(13, '♥'));
        deck.add(PlayingCards.PANI.updatePlayingCards(1, '♥'));
        deck.add(PlayingCards.PANI.updatePlayingCards(8, '♦'));

        deck.add(PlayingCards.CATB.updatePlayingCards(9, '♦'));
        deck.add(PlayingCards.CATB.updatePlayingCards(10, '♦'));
        deck.add(PlayingCards.CATB.updatePlayingCards(12, '♦'));
        deck.add(PlayingCards.CATB.updatePlayingCards(14, '♥'));

        deck.add(PlayingCards.STAG.updatePlayingCards(9, '♠'));
        deck.add(PlayingCards.STAG.updatePlayingCards(9, '♠'));
          
        deck.add(PlayingCards.WELL.updatePlayingCards(3, '♥'));

        deck.add(PlayingCards.GATL.updatePlayingCards(10, '♥'));

        deck.add(PlayingCards.DUEL.updatePlayingCards(13, '♦'));
        deck.add(PlayingCards.DUEL.updatePlayingCards(12, '♠'));
        deck.add(PlayingCards.DUEL.updatePlayingCards(8, '♣'));

        deck.add(PlayingCards.INDI.updatePlayingCards(14, '♦'));
        deck.add(PlayingCards.INDI.updatePlayingCards(1, '♦'));

        deck.add(PlayingCards.GENE.updatePlayingCards(9, '♣'));
        deck.add(PlayingCards.GENE.updatePlayingCards(13, '♠'));

        deck.add(PlayingCards.SALO.updatePlayingCards(5, '♥'));
    }

    public void startGame(List<Player> players) {
        for (Player player : players) {
            player.updateInfo(classes.get(0), characters.get(0), Weapons.COLT);
            for (int index = 0; index < player.getInfo().getLife(); ++index) {
                player.getInfo().addCard(deck.remove(0));
            }
            if (classes.get(0) == Classes.SHER) {
                playerTurn = player.getInfo().getId();
            }
            classes.remove(0);
            characters.remove(0);
        }
        this.players = new ArrayList<Player>(players);
        started = true;
    }

    public void startTurn(Player player) {
        if (!player.getInfo().isAlive()) {
            return;
        }

        if (player.getInfo().getCardsInPlay().contains(PermanentCards.DYNA)) { // poate nu gaseste contains
            Card fateCard = deck.remove(0);
            discardedDeck.add(0, fateCard);

            if (fateCard.getCardType().getValue() == '♠' && fateCard.getCardType().getKey() >= 2 &&
                fateCard.getCardType().getKey() <= 9) {
                for (PermanentCards card : player.getInfo().getCardsInPlay()) {
                    if (card == PermanentCards.DYNA) {
                        discardedDeck.add(0, card);
                        break;
                    }
                }
                player.getInfo().loseLife();
                player.getInfo().loseLife();
                player.getInfo().loseLife();
                if (!player.getInfo().isAlive()) {
                    players.remove(player);
                    return;
                }

            } else {
                for (PermanentCards card : player.getInfo().getCardsInPlay()) {
                    if (card == PermanentCards.DYNA) {
                        players.get((player.getInfo().getId() + 1) % players.size()).
                                getInfo().getCardsInPlay().add(card); // ID poate nu e de la 0 ci 1
                        break;
                    }
                }
            }
            player.getInfo().getCardsInPlay().remove(PermanentCards.DYNA); // poate nu gaseste bine remove
        }

        if (player.getInfo().getCardsInPlay().contains(PermanentCards.JAIL)) {
            Card fateCard = deck.remove(0);
            discardedDeck.add(0, fateCard);
            for (PermanentCards card : player.getInfo().getCardsInPlay()) {
                if (card == PermanentCards.DYNA) {
                    discardedDeck.add(0, card);
                    break;
                }
            }
            if (fateCard.getCardType().getValue() != '♥') {
                return;
            }
        }
        player.getInfo().addCard(deck.remove(0));
        player.getInfo().addCard(deck.remove(0));
    }

    public void playCard() {

    }

    /**
     * @return the nrOfPlayers
     */
    public byte getNrOfPlayers() {
        return nrOfPlayers;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}