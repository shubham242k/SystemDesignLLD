interface Chair {
  void hasLegs();
  void sitOn();
}

interface Table {
  void type();
  void use();
}

abstract class FurnitureFactory {
  Chair chair;
  Table table;

  abstract Chair getChair();
  abstract Table getTable();
}

class Factory {
  FurnitureFactory getFactory(String type){
    if(type.equals("Modern")){
      return new ModernFurnitureFactory();
    } else if(type.equals("Classic")){
      return new ClassicFurnitureFactory();
    }

    return null;
  }
}

class ModernFurnitureFactory extends FurnitureFactory{
  Chair getChair(){
    return new ModernChair();
  }

  Table getTable(){
    return new ModernTable();
  }

}

class ClassicFurnitureFactory extends FurnitureFactory{
  Chair getChair(){
    return new ClassicChair();
  }

  Table getTable(){
    return new ClassicTable();
  }

}

class ModernChair implements Chair {
  public void hasLegs(){
    System.out.println("ModernChair have 3 legs");
  }

  public void sitOn(){
    System.out.println("Sits on soft base");
  }
}

class ClassicChair implements Chair {
  public void hasLegs(){
    System.out.println("ClassicChair have 4 legs");
  }

  public void sitOn(){
    System.out.println("Sits on hard base");
  }
}

class ModernTable implements Table {
  public void type(){
    System.out.println("Modern Type");
  }

  public void use(){
    System.out.println("For kitchen purpose");
  }
}

class ClassicTable implements Table {
  public void type(){
    System.out.println("Classic Type");
  }

  public void use(){
    System.out.println("For hall purpose");
  }
}

public class AbstractFactoryPattern {
  public static void main(String[] args) {
    Factory factory = new Factory();
    FurnitureFactory furnitureFactory = factory.getFactory("Classic");

    Chair chair = furnitureFactory.getChair();
    Table table = furnitureFactory.getTable();

    chair.hasLegs();
    chair.sitOn();
    table.type();
    table.use();
  }
}