import java.util.*;
abstract class Log {
	Log log;
	Log(Log log) {
		this.log = log;
	}
	void print(String type, String message){
		log.print(type, message);
	}
}

class InfoLog extends Log {
	String TYPE = "INFO";
	InfoLog(Log log) {
		super(log);
	}

	public void print(String type, String message) {
		if(type.equals(TYPE)) {
			System.out.println("type: and message: " + type + " " + message);
		} else {
			super.print(type, message);
		}
		
	}
}

class WarnLog extends Log {
	String TYPE = "WARN";
	WarnLog(Log log) {
		super(log);
	}

	public void print(String type, String message) {
		if(type.equals(TYPE)) {
			System.out.println("type: and message: " + type + " " + message);
		} else {
			super.print(type, message);
		}
		
	}
}

class ErrorLog extends Log {
	String TYPE = "ERROR";
	ErrorLog(Log log) {
		super(log);
	}

	public void print(String type, String message) {
		if(type.equals(TYPE)) {
			System.out.println("type: and message: " + type + " " + message);
		} else {
			System.out.println("not supported");
		}
		
	}
}


public class ChainOfResponsibilityPattern {
	public static void main(String[] args) {
		Log log = new InfoLog(new WarnLog(new ErrorLog(null)));

		log.print("INFO", "Everything works fine");
		log.print("WARN", "Warning message");
		log.print("ERROR", "Error message");
		log.print("DEBUG", "Debug message");
	}
}