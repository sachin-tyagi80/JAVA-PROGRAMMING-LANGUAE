public class GetSet {
   public static void main(String[] args) { // created a pen object called p1

    // Object
    Pen p1 = new Pen(); //consetator
    p1.setColor(("blue")); // function call
    System.out.println(p1.getColor());
    p1.setTip(5);
    System.out.println(p1.getTip());
   p1.setColor("yellow");
    System.out.println(p1.getColor());


    


  }
  
}

// Classes

class Pen{ // Properties 
   private String color;
   private int tip;

  String getColor(){ // getters
    return this.color;
  }

  int getTip(){
    return this.tip;
  }

  void setColor(String newColor){ // functions // setters
    this.color = newColor;
  }

  void setTip(int newTip){ // functions
    this.tip = newTip;
  }
}
