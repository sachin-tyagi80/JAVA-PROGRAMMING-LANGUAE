public class Oops {
  public static void main(String[] args) { // created a pen object called p1
    //Object
    Pen p1 = new Pen(); //consetator
    p1.setColor(("blue")); // function call
    System.out.println(p1.color);
    p1.setTip(5);
    System.out.println(p1.tip);
   // p1.setColor("yellow");
   p1.color = "yellow";
    System.out.println(p1.color);

    // Object
    BankAccount myAcc = new BankAccount(); // Access modifiers
    myAcc.username = "sachin";
    myAcc.setPassword("8002sachin@");



  }

  
}


// Classes

class BankAccount{ // Access modifiers
  public String username;
  private String password;
  public void setPassword(String pwd){
    password = pwd;
  }
}

class Pen{ // Properties 
  String color;
  int tip;

  void setColor(String newColor){ // functions // setters
    color = newColor;
  }

  void setTip(int newTip){ // functions
    tip = newTip;
  }
}

class Student{ // Properties
  String name;
  int age;
  float percentage;

  void calcPercentage(int phy,int chem,int math){  // functions
     percentage = (phy + chem + math) /3;

  }

}
