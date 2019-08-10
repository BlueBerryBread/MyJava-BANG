package game;

import enums.Characters;
import enums.Weapons;
import enums.Classes;
import enums.PermanentCards;

import java.util.LinkedList;

public class PlayerInformation {
    private byte id;
    private byte life;
    private byte maxLife;
    private Classes gameClass;
    private Characters character;
    private Weapons weapon;
    private LinkedList<Card> hand;
    private LinkedList<PermanentCards> cardsInPlay;

    PlayerInformation(Classes gameClass, 
                      Characters character, 
                      Weapons weapon) {
        this.gameClass = gameClass;
        this.character = character;
        this.weapon    = weapon;
        this.hand = new LinkedList<Card>();
        this.cardsInPlay = new LinkedList<PermanentCards>();
        life = 0;
        if (gameClass == Classes.SHER) {
            life++;
        }
        if (character == Characters.PAUL || 
            character == Characters.ELGR) {
            life += 3;
        } else {
            life += 4;
        }
        maxLife = life;
        id = Generator.generatePlayerId();
    }

    /**
     * removes card at given index
     * @param index to remove
     */
    public void removeCard(int index) {
        hand.remove(index);
    }

    /**
     * adds one card to hand
     * @param card to add
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * @return the hand
     */
    public LinkedList<Card> getHand() {
        return hand;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    /**
     * Gain one life (Beer / Saloon)
     */
    public void gainlife() {
        if (life < maxLife) {
            life++;
        }
    }

    /**
     * Lose one life (from bang)
     */
    public void loseLife() {
        if(isAlive()) {
            life--;
        }
    }

    /**
     * @return the id
     */
    public byte getId() {
        return id;
    }

    /**
     * @return the life
     */
    public byte getLife() {
        return life;
    }

    /**
     * @return true if player is alive
     */
    public boolean isAlive() {
        return life > 0;
    }

    /**
     * @return the character
     */
    public Characters getCharacter() {
        return character;
    }

    /**
     * @return the gameClass
     */
    public Classes getGameClass() {
        return gameClass;
    }

    /**
     * @return the cardsInPlay
     */
    public LinkedList<PermanentCards> getCardsInPlay() {
        return cardsInPlay;
    }

    /**
     * @return the weapon
     */
    public Weapons getWeapon() {
        return weapon;
    }
}