public class Player {
    Symbol symbol;
    String name;
    Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }
    public Symbol getSymbol() {
        return this.symbol;
    }

}
