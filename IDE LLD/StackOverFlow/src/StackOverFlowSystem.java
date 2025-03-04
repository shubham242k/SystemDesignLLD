import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StackOverFlowSystem {
    List<User> users;
    List<Answer> answers;
    List<Question> questions;

    public StackOverFlowSystem() {
        users = new ArrayList<>();
        answers = new ArrayList<>();
        questions = new ArrayList<>();
    }

    public User createUser(String name, String email) {
        User newUser = new User(name, email);
        users.add(newUser);
        return newUser;
    }

    public Question askQuestion(User user, String title, String content) {
        Question question = user.askQuestion(title, content);
        questions.add(question);
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer ans = user.answerQuestion(content, question);
        answers.add(ans);
        return ans;
    }

    public Comment addComment(User user, String content, Post post) {
        Comment comment = user.addComment(post, content);
        return comment;
    }

    public void voteQuestion(Question question, User user, int value) {
        user.vote(question, value);
    }

    public void voteAnswer(Answer ans, User user, int value) {
        user.vote(ans, value);
    }

    public List<Question> searchQuestionByUser(User user) {
        return user.getQuestions();
    }

    public List<Question> searchQuestionByKeyword(String query) {
        return questions.stream()
                .filter(ques ->
                    ques.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                            ques.getContent().toLowerCase().contains(query.toLowerCase())
                ).collect(Collectors.toList());
    }
}
