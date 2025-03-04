public abstract class CashManager {
    int noOfCash;
    CashManager cashManager;
    Note noteVal;

    CashManager(int noOfCash, CashManager manager, Note note) {
        this.noOfCash = noOfCash;
        this.cashManager = manager;
        this.noteVal = note;
    }

    public boolean withdrawMoney(int amount) {
        return cashManager.withdrawMoney(amount);
    }

    public void cashLeft() {
        System.out.println(noteVal + ": " + noOfCash);
        if(cashManager == null) {
            return;
        }
        cashManager.cashLeft();
    }
}
