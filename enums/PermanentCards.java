package enums;

import game.Card;
import game.Pair;

public enum PermanentCards implements Card {
    JAIL("Jail" + "\n" + CardAttributes.RULEBOOK + "\n"),
    DYNA("Dynamite" + "\n" + CardAttributes.RULEBOOK + "\n"),
    BARR("Barrel" + "\n" + CardAttributes.RULEBOOK + "\n"),
    SCOP("Scope" + "\n" + CardAttributes.RULEBOOK + "\n"),
    MUST("Mustang" + "\n" + CardAttributes.RULEBOOK + "\n");
    private String value;
    private Pair<Integer, Character> cardType;

    PermanentCards(String value) {
        this.value = value;
    }

    public PermanentCards updatePermanentCards(Integer number, Character chr) {
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