public class Demo {
    public static void main(String[] arg) {
        ATM atm = new ATM(5, 9, 5);

        Card card = new Card("Shubham", "2793", 20000);

        atm.insertTheCard(card);

        atm.enterPin("2793");
        atm.cashLeft();

        atm.chooseOption(0);
        atm.withdraw(30000);
        atm.cashLeft();

        atm.chooseOption(1);
        atm.checkBalance();
    }
}
