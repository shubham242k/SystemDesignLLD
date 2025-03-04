// Singleton : 
// Singleton Pattern is a creational design pattern that guarantees a class has only one instance and provides a global point of access to it.


class Singleton {
	private static Singleton singleton;

	private Singleton(){}

	public static Singleton getInstance(){
		if(singleton == null) {
			singleton = new Singleton();
		} 
		System.out.println("got the instance");
		return singleton;
	}
}

public class SingletonCreationalPattern {
  public static void main(String[] args) {
      Singleton instance = Singleton.getInstance();
      Singleton instance2 = Singleton.getInstance();

      if(instance2 == instance) {
      	System.out.println("same instance");
      }
  }
}