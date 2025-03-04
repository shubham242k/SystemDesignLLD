public class OptionState extends ATMState{
    OptionState(ATM atm) {
        super(atm);
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Card already added. Choose option");
    }

    @Override
    public void chooseOption(int option) {
        atm.setState(atm.getMenu().get(option));
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Choose option");
    }

    @Override
    public void cancel() {
        atm.setState(new IdleState(atm));
    }

    @Override
    public void withDrawCash(int money) {
        System.out.println("Choose option");
    }

    @Override
    public void checkBalance() {
        System.out.println("Choose option");
    }
}