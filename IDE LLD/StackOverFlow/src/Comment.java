public class Comment {
    String id;
    String comment;
    User user;

    Comment(String comment, User user) {
        this.id = String.valueOf((System.currentTimeMillis() % Integer.MAX_VALUE));
        this.comment = comment;
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void displayComment() {
        System.out.println("Comment: " + comment + ". published by: " + user.getUserName());
    }
}
