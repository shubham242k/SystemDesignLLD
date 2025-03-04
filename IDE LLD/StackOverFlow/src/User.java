import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String email;
    String id;
    int reputation;
    List<Question> questions;
    List<Answer> answers;
    User(String name, String email){
        this.id = String.valueOf((System.currentTimeMillis() % Integer.MAX_VALUE));
        this.name = name;
        this.email = email;
        this.reputation = 0;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public String getUserName() {
        return name;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public Question askQuestion(String title, String content) {
        Question question = new Question(title, content, this);
        questions.add(question);
        updateReputation(5);
        return question;
    }

    public Answer answerQuestion(String content, Question question) {
        Answer answer = new Answer(content, this, question);
        question.addAnswer(answer);
        answers.add(answer);
        updateReputation(10);
        return answer;
    }

    public void vote(Post post, int val) {
        post.addVote(this, val);
    }

    public Comment addComment(Post post, String content) {
        Comment comment = new Comment(content, this);
        post.addComment(comment);
        updateReputation(2);
        return comment;
    }

    public synchronized void updateReputation(int value) {
        this.reputation += value;
        if (this.reputation < 0) {
            this.reputation = 0;
        }
    }

    public void getReputation() {
        System.out.println(name +"'s reputation: " + reputation);
    }

}
