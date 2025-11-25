public class ArraysLinearSearch {
  public static int LinearSearch(int numbers[], int key) {
    for(int i=0;i<numbers.length;i++){
      if(numbers[i] == key){
        return i;
      }
    }
    return -1;
    
  }
  public static void main(StringDemo[] args) {
    int numbers[] = {2,4,5,6,7,8,10,56};
    int key = 10;
    int index = LinearSearch(numbers, key);
    if(index == -1){
      System.out.println("Not found");
    }else{
      System.out.println("key is ay index :" + index);
    }
    
  }
  
}
