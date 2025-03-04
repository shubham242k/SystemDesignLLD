public class Vote {
    User user;
    int value;
    Vote(User user, int val) {
        this.user = user;
        this.value = val;
    }

    public User getUser() {
        return user;
    }

    public int getValue() {
        return value;
    }
}
