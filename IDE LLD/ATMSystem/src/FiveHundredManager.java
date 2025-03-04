public class FiveHundredManager extends CashManager {
    FiveHundredManager(int avail, CashManager manager) {
        super(avail, manager, Note.FIVE_HUNDRED);
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
                boolean flag = super.withdrawMoney(leftAmount);
                if (flag == false) {
                    noOfCash += cashProvided;
                    return false;
                }
            }
            return true;
        } else {
            return super.withdrawMoney(amount);
        }
    }
}
