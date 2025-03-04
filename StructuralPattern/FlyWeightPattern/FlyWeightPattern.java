import java.util.*;
abstract class Robot {
	int size;
	String color;
	Robot(int size, String color) {
		this.size = size;
		this.color = color;
	}
	abstract void draw(int x, int y);
} 

class OldRobot extends Robot {
	OldRobot(int size, String color) {
		super(size, color);
	}

	public void draw(int x, int y) {
		System.out.println("draw oldrobot with "+ size + " and " + color + " at " + x + " and " + y);
	}
}

class NewRobot extends Robot {
	NewRobot(int size, String color) {
		super(size, color);
	} 

	public void draw(int x, int y) {
		System.out.println("draw NewRobot with " +size + " and " + color + " at " + x + " and " + y);
	}
}

class RobotFactory {
	HashMap<String, Robot> map;

	RobotFactory(){
		map = new HashMap<>();
	}

	Robot getRobot(String type) {
		if(map.containsKey(type)) return map.get(type);

		else if(type.equals("OLD")) {
			map.put(type, new OldRobot(5, "black&white"));
		} else if(type.equals("NEW")) {
			map.put(type, new NewRobot(10, "ColorGradient"));
		}

		return map.get(type);
	}
}


public class FlyWeightPattern {
	public static void main(String[] args) {
		RobotFactory robotFactory = new RobotFactory();

		Robot robot = robotFactory.getRobot("NEW");
		robot.draw(1,2);
	}
}