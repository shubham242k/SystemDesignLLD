import java.util.ArrayList;
import java.util.List;

public class Topic {

    String topicName;
    List<Subscriber> subscribers;
    Topic(String name) {
        this.topicName = name;
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishMessage(String message) {
        for(Subscriber sub : subscribers) {
            sub.processMessage(message);
        }
    }
}
