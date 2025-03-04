class RideService {
	public void requestRide(String pas, String src, String des) {
		System.out.println("Requested ride for " + pas + ", from " + src + " to " + des);
	}

	public void cancelRide(String pas) {
		System.out.println("Cancel ride for " + pas);
	}
}

interface Command {
	void execute();
}

class RequestCommand implements Command {
	RideService rideService;
	String pas, src, des;

	RequestCommand(RideService rideService, String pas, String src, String des) {
		this.rideService = rideService;
		this.pas = pas;
		this.src = src;
		this.des = des;
	}

	public void execute() {
		rideService.requestRide(pas, src, des);
	}
}

class CancelCommand implements Command {
	RideService rideService;
	String pas;

	CancelCommand(RideService rideService, String pas) {
		this.rideService = rideService;
		this.pas = pas;
	}

	public void execute() {
		rideService.cancelRide(pas);
	}
}

class RideInvoker{
	public void processRequest(Command command) {
        command.execute();
    }
}

public class CommandPattern {
	public static void main(String[] args) {
		RideService rideService = new RideService();
		Command requestCommand1 = new RequestCommand(rideService, "Shubham", "nan", "vik");
		Command cancelCommand1 = new CancelCommand(rideService, "Shubham");

		RideInvoker rideInvoker = new RideInvoker();
		rideInvoker.processRequest(requestCommand1);
		rideInvoker.processRequest(cancelCommand1);

	}
}