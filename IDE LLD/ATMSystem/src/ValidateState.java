public class ValidateState extends ATMState{
    ValidateState(ATM atm) {
        super(atm);
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Card already added.");
    }

    @Override
    public void chooseOption(int option) {
        System.out.println("Enter PIN first");
    }

    @Override
    public void enterPIN(String pin) {
        boolean flag = atm.getInsertedCard().validatePin(pin);
        if(flag == true) {
            System.out.println("PIN: " + pin + " matched");
            atm.setState(new OptionState(atm));
        } else {
            System.out.println("Wrong PIN");
        }
    }

    @Override
    public void cancel() {
        atm.setState(new IdleState(atm));
    }

    @Override
    public void withDrawCash(int money) {
        System.out.println("Enter PIN first");
    }

    @Override
    public void checkBalance() {
        System.out.println("Enter PIN first");
    }
}
