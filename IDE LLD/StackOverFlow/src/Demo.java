import java.util.List;

public class Demo {
    public static void main(String[] args){
        StackOverFlowSystem system = new StackOverFlowSystem();

        User user1 = system.createUser("Shubham", "shub@gmail.com");
        User user2 = system.createUser("Pujika", "puji@gmail.com");
        User user3 = system.createUser("Manish", "mani@gmail.com");

        Question ques1 = system.askQuestion(user1, "StackOverflow?", "What is stack over flow?");

        Answer ans1 = system.answerQuestion(user2, ques1, "It is platform where people can ask tech questions");
        system.addComment(user3, "Thats true", ans1);

        Answer ans2 = system.answerQuestion(user3, ques1, "It is platform where people can ask tech questions");
        system.addComment(user1, "Got the answer", ques1);

        user3.vote(ans2, 1);
        Question ques2 = system.askQuestion(user2, "World?", "What is world?");

        user1.getReputation();
        user2.getReputation();
        user3.getReputation();

        List<Question> result = system.searchQuestionByKeyword("world");
        for(Question question : result) {
            question.getPost();
        }

    }
}
