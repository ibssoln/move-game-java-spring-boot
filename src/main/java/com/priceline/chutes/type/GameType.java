package com.priceline.chutes.type;

public enum GameType {

    C_LAD("CHUTES_AND_LADDER"), S_LAD("SNAKE_AND_LADDER");

    private GameType(final String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

}
