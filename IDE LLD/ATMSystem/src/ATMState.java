public abstract class ATMState {
    ATM atm;
    ATMState(ATM atm) {
        this.atm = atm;
    }

    public abstract void insertCard(Card card);
    public abstract void chooseOption(int option);
    public abstract void enterPIN(String pin);
    public abstract void cancel();
    public abstract void withDrawCash(int money);
    public abstract void checkBalance();

}
