public class Interfaces {
  public static void main(String[] args) {
    Queen q = new Queen();
    q.moves();
    
  }
  
}

interface CheesPlayer{
  void moves();
}

class Queen implements CheesPlayer{
  public void moves(){
    System.out.println("up,down,left,right,diagonal(in all 4 dirns)");
  }
}

class Rook implements CheesPlayer{
  public void moves(){
    System.out.println("up,down,left,right,");
  }
}

class king implements CheesPlayer{
  public void moves(){
    System.out.println("up,down,left,right,diagonal(by 1 step)");
  }
}
