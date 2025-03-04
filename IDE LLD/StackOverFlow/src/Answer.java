import java.util.ArrayList;
import java.util.List;

public class Answer extends Post{
    Question associatedQues;

    Answer(String content, User user, Question question) {
        super(user, content);
        this.associatedQues = question;
    }

    void displayContent() {
        System.out.println("ANSWER: " + content);
        System.out.println("published by: " + user.getUserName());
    }

    public void displayComments() {
        System.out.println("Comments on Answer");
        for (Comment comment : commentList) {
            comment.displayComment();
        }
    }

    public void displayAnswerPost() {
        displayContent();
        displayComments();
        System.out.println("----------------");
    }
}
