package game;

import java.util.Random;

public final class Generator {
    
    private static byte id = 0;
    private static final Random generator = new Random();
    private Generator() {

    }

    public static byte generatePlayerId() {
        id++;
        return id;
    }

    public static Integer generateGameSeed() {
        return generator.nextInt();
    }

    /**
     * @return the generator
     */
    public static Random getGenerator() {
        return generator;
    }
}