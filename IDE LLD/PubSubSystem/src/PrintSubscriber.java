import java.util.ArrayList;
import java.util.List;

public class PrintSubscriber extends Subscriber{
    String name;
    PrintSubscriber(String name) {
        super();
        this.name = name;
    }
    public void processMessage(String message) {
        System.out.println(name + ": " + message);
    }

    public String getName(){
        return this.name;
    }
}
