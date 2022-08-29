package model.enums;

public enum Level {
    LEVEL_1(1, 2000),
    LEVEL_2(2, 3000),
    LEVEL_3(3, 4000),
    LEVEL_4(4, 5000),
    LEVEL_5(5, 6000),
    LEVEL_6(6, 7000),
    LEVEL_7(7, 8000),
    LEVEL_8(8, 9000),
    LEVEL_9(9, 10000),
    LEVEL_10(10, 11000),
    LEVEL_11(11, 12000),
    LEVEL_12(12, 13000),
    LEVEL_13(13, 14000),
    LEVEL_14(14, 15000),
    LEVEL_15(15, 16000);

    private final int value;
    private final int value2;

    private Level(int lvl, final int necessary) {
        value = lvl;
        value2 = necessary;
    }

    public int getLevel() {
        return value;
    }

    public int getNecessaryXP() {
        return value2;
    }
}
