public class PubSubSystemDemo {
    public static void main(String[] args) {
        Topic topic1 = new Topic("Topic1");
        Topic topic2 = new Topic("Topic2");

        Publisher publisher1 = new Publisher("Publisher1");
        Publisher publisher2 = new Publisher("Publisher2");

        Subscriber subscriber1 = new PrintSubscriber("Subscriber1");
        Subscriber subscriber2 = new PrintSubscriber("Subscriber2");
        Subscriber subscriber3 = new PrintSubscriber("Subscriber3");

        subscriber1.subscribeToTopic(topic1);
        subscriber1.subscribeToTopic(topic2);

        subscriber2.subscribeToTopic(topic1);

        subscriber3.subscribeToTopic(topic2);

        publisher1.publishMessageToTopic("message1", topic1);
        publisher2.publishMessageToTopic("message2", topic2);

        subscriber1.unSubscribeToTopic(topic2);
        publisher2.publishMessageToTopic("message2", topic2);
    }
}
