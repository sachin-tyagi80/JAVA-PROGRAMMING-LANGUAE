public class BinaryString {
  public static void printBinString(int n,int lastplace,String str){
    //base case
    if(n == 0){
      System.err.println(str);
      return;
    }
    //kaam
    //sit 0 on chair n
    // if(lastplace == 0){
    //   printBinString(n-1, 0, str.append("0"));
    //   printBinString(n-1,1, str.append("1"));
    // }
    // else{
    //   printBinString(n-1, 0, str.append("0"));
    // }
     //kaam
    printBinString(n-1, 0, str+"0");
    if(lastplace == 0){
      printBinString(n-1, 1, str+"1");
    }
    
  }


  public static void main(String[] args) {
    printBinString(3, 0, "");
  }
  
}
