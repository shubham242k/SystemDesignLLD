public class IdleState extends ATMState{
    IdleState(ATM atm) {
        super(atm);
    }
    @Override
    public void insertCard(Card card) {
        atm.setInsertedCard(card);
        atm.setState(new ValidateState(atm));
    }

    @Override
    public void chooseOption(int option) {
        System.out.println("Insert card first");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Insert card first");
    }

    @Override
    public void cancel() {

    }

    @Override
    public void withDrawCash(int money) {
        System.out.println("Insert card first");
    }

    @Override
    public void checkBalance() {
        System.out.println("Insert card first");
        atm.removeCard();
    }
}
