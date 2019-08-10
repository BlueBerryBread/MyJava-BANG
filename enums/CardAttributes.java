package enums;

public enum CardAttributes {
    BANG("Bang!"),
    MISS("Miss!"),
    LIFE("Regain 1 life point."),
    DISCARD("Force to discard a card."),
    DRAW("Draw a card."),
    ANY("Any one player."),
    ALL("All other players."),
    REACH("Any one player at a reachable distance."),
    DISTREACH("Any one player at a distance up to the number."),
    RULEBOOK("Details in the rule book.");
    private String value;

    CardAttributes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}