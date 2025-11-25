public class Constructors {
  public static void main(String[] args) {
    Student s1 = new Student();
    Student s2 = new Student("sachin");
    Student s3 = new Student(123);

    System.out.println(s2.name);
    System.out.println(s3.roll);
  }
  
}

class Student{
  String name;
  int roll;

  Student(){  // Non parameterized
    System.out.println("my name is sachin");
  }
  Student(String name){ // parameterized
    this.name= name;
  }
  Student(int roll){  // parameterized
    this.roll = roll;
  }
}