interface Prototype {
  public Prototype clone();
}

class Concrete implements Prototype{
  public int sn;
  public String name;

  public Concrete(int sn, String name) {
    this.sn = sn;
    this.name = name;
  }

  public Concrete(Concrete concrete) {
    this.sn = concrete.sn;
    this.name = concrete.name;
  }

  public Prototype clone() {
    return new Concrete(this.sn, this.name);
  }

}

public class PrototypePattern {
  public static void main(String[] args) {
    Prototype obj = new Concrete(0, "Shubham");

    Prototype cloned = obj.clone();

    System.out.println(cloned.sn + " "+  cloned.name);
  }
}