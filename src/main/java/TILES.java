public enum TILES {
    FLOOR ('.'),
    WALL ('*');

    private final Character symbol;
    private TILES(Character symbol){
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}
