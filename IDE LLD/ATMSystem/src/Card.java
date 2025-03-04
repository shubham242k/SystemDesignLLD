public class Card {
    private String PIN;
    private String cardHolder;
    private int balance;
    Card(String cardHolder, String PIN, int balance) {
        this.cardHolder = cardHolder;
        this.PIN = PIN;
        this.balance = balance;
    }

    public void deductMoney(int amt) {
        this.balance -= amt;
    }

    public boolean validatePin(String pin) {
        return pin.equals(PIN);
    }

    public String getCardHolder() {
        return this.cardHolder;
    }

    public int getBalance() {
        return balance;
    }
}
