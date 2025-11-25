import java.util.Arrays;
import java.util.Collections;
public class InbuiltSort {
  public static void printArr(Integer arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
     
  }
  
  public static void main(StringDemo[] args) {
    //int arr[] = {5,4,1,3,2};
    //Arrays.sort(arr);//asecnding order
    //Arrays.sort(arr,0,3);
    Integer arr[] = {5,4,1,3,2};
    Arrays.sort(arr,Collections.reverseOrder());
    printArr(arr);
  }
  
}


