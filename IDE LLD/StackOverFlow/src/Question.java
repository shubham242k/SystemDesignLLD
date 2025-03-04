import java.util.List;
import java.util.ArrayList;

public class Question extends Post {
    String title;
    List<Answer> answerList;

    Question(String title, String content, User user) {
        super(user, content);
        this.title = title;
        this.answerList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void addAnswer(Answer answer) {
        if(!answerList.contains(answer)) {
            answerList.add(answer);
        }
    }

    public void displayContent() {
        System.out.println("TITLE: " + title);
        System.out.println("QUESTION: " + content);
        System.out.println("- published by: " + user.getUserName());
    }

    public void displayComments() {
        System.out.println("----- COMMENTS ON QUESTION -----");
        for (Comment comment : commentList) {
            comment.displayComment();
        }
    }

    public void displayAnswers() {
        System.out.println("----- ANSWERS -----");
        for(Answer answer : answerList) {
            answer.displayAnswerPost();
        }
    }

    public void getPost() {
        System.out.println("------------------------------------------------------");
        displayContent();
        System.out.println("------------------------------------------------------");
        displayAnswers();
        System.out.println("------------------------------------------------------");
        displayComments();
    }
}
