package enums;

import game.Card;
import game.Pair;

public enum PlayingCards implements Card {
    BANG("Bang!" + "\n" + CardAttributes.BANG.getValue() +"\n" + CardAttributes.ANY.getValue() + "\n"),
    MISS("Missed!" + "\n" + CardAttributes.MISS.getValue() + "\n"),
    BEER("Beer" + "\n" + CardAttributes.LIFE.getValue() + "\n"),
    PANI("PANIC!" + "\n" + CardAttributes.DRAW.getValue() + "\n" + CardAttributes.DISTREACH.getValue() + " 1\n"),
    CATB("Cat Balou" + "\n" + CardAttributes.DISCARD.getValue() + "\n" + CardAttributes.ANY.getValue() + "\n"),
    STAG("Stagecoach" + "\n" + CardAttributes.DRAW.getValue() + " x2\n"),
    WELL("Wells Fargo" + "\n" + CardAttributes.DRAW.getValue() + " x3\n"),
    GATL("Gatling" + "\n" + CardAttributes.BANG.getValue() + "\n" + CardAttributes.ALL.getValue() + "\n"),
    DUEL("Duel" + "\n" + CardAttributes.RULEBOOK.getValue() + "\n"),
    INDI("Indians!" + "\n" + CardAttributes.RULEBOOK.getValue() + "\n"),
    GENE("General Store" + "\n" + CardAttributes.RULEBOOK.getValue() + "\n"),
    SALO("Saloon" + "\n" + CardAttributes.LIFE.getValue() + "\n" + CardAttributes.ALL.getValue() + 
         "\n&\n" + CardAttributes.LIFE.getValue());
    private String value;
    private Pair<Integer, Character> cardType;

    PlayingCards(String value) {
        this.value = value;
    }

    public PlayingCards updatePlayingCards(Integer number, Character chr) {
        cardType = new Pair<Integer, Character>(number, chr);
        return this;
    }

    /**
     * @param cardType the cardType to set
     */
    public void setCardType(Pair<Integer, Character> cardType) {
        this.cardType = cardType;
    }

    /**
     * @return the cardType
     */
    public Pair<Integer, Character> getCardType() {
        return cardType;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}