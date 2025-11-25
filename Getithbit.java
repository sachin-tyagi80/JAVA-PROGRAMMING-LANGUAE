public class Getithbit {
  public static int getIthBit(int n, int k){
    int bitMask = 1<<k;
    if((n & bitMask) == 0){
      return 0;
    }
    else{
      return 1;
    }
  }
  public static int setIthBit(int n,int i){
    int bitMask = 1<<i;
    return n | bitMask;

  }
  public static int clearIthBit(int n,int i){
    int bitMask = ~(1<<i);
    return n & bitMask;
  }
  
  public static int updateIthBit(int n,int i,int newBit){
    if(newBit == 0){
      return clearIthBit(n, i);
    }else{
      return setIthBit(n, i);
    }
  }
  public static int clearLastIthBit(int n,int i){
    int bitMask = (~0)<<i;
    return n & bitMask;
  }
  public static int clearRangeOfBits(int n,int i,int j){
    int a = ((~0)<<(j+1));
    int b = (1<<i)-1;
    int bitMask = a|b;
    return n & bitMask;

  }
  public static void main(String[] args) {
    System.out.println(getIthBit(10,2));
    System.out.println(setIthBit(10,2));
    System.out.println(clearIthBit(10,1));
    System.out.println(updateIthBit(10,2,1));
    System.out.println(clearLastIthBit(15,2));
    System.out.println(clearRangeOfBits(10, 2, 4));
    

    
  }
  
}
