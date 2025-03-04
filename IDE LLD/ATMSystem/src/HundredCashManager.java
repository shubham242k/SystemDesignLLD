public class HundredCashManager extends CashManager{
    HundredCashManager(int avail, CashManager manager) {
        super(avail, manager, Note.HUNDRED);
    }
    @Override
    public boolean withdrawMoney(int amount) {
        int required = amount / noteVal.getVal();
        if(required > 0) {
            int cashProvided = 0;
            if(noOfCash >= required) {
                cashProvided = required;
                noOfCash -= required;
            } else {
                cashProvided = noOfCash;
                noOfCash = 0;
            }
            int leftAmount = amount - (cashProvided * noteVal.getVal());
            if (leftAmount != 0) {
                noOfCash += cashProvided;
                return false;
            }
            return true;
        } else {
            return false;
        }

    }
}
