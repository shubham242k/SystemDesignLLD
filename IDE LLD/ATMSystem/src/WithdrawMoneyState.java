public class WithdrawMoneyState extends ATMState{
    WithdrawMoneyState(ATM atm) {
        super(atm);
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Withdraw money State. Cant insert card");
    }

    @Override
    public void chooseOption(int option) {
        System.out.println("Withdraw money State. Cant choose option");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Withdraw money State. Cant enter PIN");
    }

    @Override
    public void cancel() {
        atm.setState(new IdleState(atm));
    }

    @Override
    public void withDrawCash(int money) {
        if(atm.getInsertedCard().getBalance() < money) {
            System.out.println("Not sufficient balance: Current balance is $" + atm.getInsertedCard().getBalance());
        }
        boolean flag = atm.getCashManager().withdrawMoney(money);
        if(flag) {
            atm.getInsertedCard().deductMoney(money);
            System.out.println(money + "$ Money withdrawn.");
        } else {
            System.out.println("Not enough cash available in ATM");
        }
        atm.setState(new OptionState(atm));
    }

    @Override
    public void checkBalance() {
        System.out.println("Withdraw money State. Cant check balance");
    }
}

