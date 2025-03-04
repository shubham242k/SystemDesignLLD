public class CashCounter {
    int machineBalance;
    public CashCounter(int balance) {
        this.machineBalance = balance;
    }

    public int acceptMoney(int entered, int required) {
        if(entered == required) {
            machineBalance += entered;
            return 0;
        } else if(entered > required) {
            machineBalance += required;
            return entered - required;
        } else {
            throw new RuntimeException("Unsufficient amount paid");
        }
    }
}