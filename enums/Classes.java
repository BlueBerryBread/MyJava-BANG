package enums;

public enum Classes {
    SHER("Sheriff"),
    DEPU("Deputy Sheriff"),
    OUTL("Outlaw"),
    RENE("Renegade");
    private String value;

    Classes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}