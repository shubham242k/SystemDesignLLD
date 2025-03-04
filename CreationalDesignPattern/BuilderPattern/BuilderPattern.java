class Student {
  int rollNo;
  int admissionNo;
  String firstName;
  String lastName;
  String fatherName;

  public int getRollNo(){
    return rollNo;
  }
  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public String getFatherName(){
    return fatherName;
  }
  public int getAdmissionNo(){
    return admissionNo;
  }

  public Student(StudentBuilder builder){
    this.rollNo = builder.rollNo;
    this.admissionNo = builder.admissionNo;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.fatherName = builder.fatherName;
  }
}

class StudentBuilder {
  int rollNo;
  int admissionNo;
  String firstName;
  String lastName;
  String fatherName;

  public StudentBuilder setRollNo(int rollNo){
    this.rollNo = rollNo;
    return this;
  } 

  public StudentBuilder setAdmissionNo(int admissionNo){
    this.admissionNo = admissionNo;
    return this;
  } 

  public StudentBuilder setFirstName(String firstName){
    this.firstName = firstName;
    return this;
  } 

  public StudentBuilder setLastName(String lastName){
    this.lastName = lastName;
    return this;
  } 

  public StudentBuilder setFatherName(String fatherName){
    this.fatherName = fatherName;
    return this;
  } 

  public Student build() {
    return new Student(this);
  }

}
public class BuilderPattern {
  public static void main(String[] args) {
    StudentBuilder builder = new StudentBuilder();

    Student student = builder.setRollNo(1).setAdmissionNo(3).setFirstName("Shubham").setLastName("Aggarwal").setFatherName("Sandeep Kumar").build();

    System.out.println(student.getRollNo() + " " + student.getAdmissionNo() + " " + student.getFirstName() + " " + student.getLastName() + " " + student.getFatherName());
  }
}