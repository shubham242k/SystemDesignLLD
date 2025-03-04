import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    List<Topic> topics;

    Subscriber(){
        topics = new ArrayList<>();
    }
    public abstract void processMessage(String message);

    public void unSubscribeToTopic(Topic topic) {
        topics.remove(topic);
        topic.removeSubscriber(this);
    }

    public void subscribeToTopic(Topic topic) {
        topics.add(topic);
        topic.addSubscriber(this);
    }
}
