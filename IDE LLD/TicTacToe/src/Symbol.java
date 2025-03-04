public enum Symbol {
    X('X'),
    O('O');

    char val;
    Symbol(char val) {
        this.val = val;
    }

    public char getSymbol() {
        return this.val;
    }
}
