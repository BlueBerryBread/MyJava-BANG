package enums;

import game.Card;
import game.Pair;

public enum Weapons implements Card {
    COLT("Colt .45", 1),
    SCHO("Schofield", 2),
    REMI("Remington", 3),
    CARA("Rev. Carabine", 4),
    WINC("Winchester", 5),
    VOLC("Volcanic", 1);
    private String value;
    private Integer range;
    private Pair<Integer, Character> cardType;

    Weapons(String value, Integer range) {
        this.value = value;
        this.range = range;
    }

    public Weapons updateWeapons(Integer number, Character chr) {
        cardType = new Pair<Integer, Character>(number, chr);
        return this;
    }

    public String getValue() {
        return value;
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
     * @param range the range to set
     */
    public void setRange(Integer range) {
        this.range = range;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    public Integer getRange() {
        return range;
    }
}