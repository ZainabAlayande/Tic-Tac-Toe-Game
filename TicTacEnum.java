package TicTacToeGame;

public enum TicTacEnum {

    X("X"), O("O"), EMPTY(" ");

    private String name;
    private String symbol;
    TicTacEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
