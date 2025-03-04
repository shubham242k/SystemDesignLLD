public class Publisher {
    String name;
    Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void publishMessageToTopic(String message,Topic topic) {
        topic.publishMessage(message);
    }
}
