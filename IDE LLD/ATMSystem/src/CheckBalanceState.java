public class CheckBalanceState extends ATMState{
    CheckBalanceState(ATM atm) {
        super(atm);
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Balance checking State. Cant insert card");
    }

    @Override
    public void chooseOption(int option) {
        System.out.println("Balance checking State. Cant choose option");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Balance checking State. Cant enter PIN");
    }

    @Override
    public void cancel() {
        atm.setState(new IdleState(atm));
    }

    @Override
    public void withDrawCash(int money) {
        System.out.println("Balance checking State. Cant withdraw money");
    }

    @Override
    public void checkBalance() {
        System.out.println("Current balance: $" + atm.getInsertedCard().getBalance());
        atm.setState(new OptionState(atm));
    }
}
