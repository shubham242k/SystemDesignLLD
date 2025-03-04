public enum Note {
    HUNDRED (100),
    FIVE_HUNDRED (500),
    THOUSAND (1000);

    private int val;
    Note(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}
