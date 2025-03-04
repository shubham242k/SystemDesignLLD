import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ATM {
    Card insertedCard;
    CashManager cashManager;
    ATMState state;
    List<ATMState> menu;
    ATM(int hundred, int fiveHundred, int thousand) {
        state = new IdleState(this);
        cashManager = new ThousandCashManager(thousand, new FiveHundredManager(fiveHundred, new HundredCashManager(hundred, null)));
        menu = new ArrayList<>();
        menu.add(new WithdrawMoneyState(this));
        menu.add(new CheckBalanceState(this));
    }
    public void insertTheCard(@NotNull Card card) {
        state.insertCard(card);
    }
    public Card getInsertedCard() {
        return this.insertedCard;
    }

    public void enterPin(String pin) {
        state.enterPIN(pin);
    }

    public void chooseOption(int option) {
        state.chooseOption(option);
    }

    public void checkBalance() {
        state.checkBalance();
    }

    public void withdraw(int amount) {
        state.withDrawCash(amount);
    }

    public void cancelTransaction() {
        state.cancel();
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public List<ATMState> getMenu() {
        return this.menu;
    }

    public CashManager getCashManager() {
        return cashManager;
    }

    public void setInsertedCard(Card card) {
        this.insertedCard = card;
    }

    public void removeCard(){
        this.insertedCard = null;
    }

    public void cashLeft() {
        cashManager.cashLeft();
    }
}
