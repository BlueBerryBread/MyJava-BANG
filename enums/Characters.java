package enums;

public enum Characters {
    PAUL("Paul Regret"),
    JOUR("Jourdonnais"),
    BLAC("Black Jack"),
    SLAB("Slab the Killer"),
    ELGR("El Gringo"),
    JESS("Jesse Jones"),
    SUZY("Suzy Lafayette"),
    WILL("Willy the Kid"),
    ROSE("Rose Doolan"),
    PEDR("Pedro Ramirez"),
    SIDK("Sid Ketchum"),
    LUCK("Lucky Duke"),
    VULT("Vulture Sam"),
    CALA("Calamity Janet"),
    KITC("Kit Carlson"),
    BART("Bart Cassidy");
    private String value;

    Characters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}