public class InsetionSort {
  public static void Sort(int arr[]){
    for(int i =1;i<arr.length; i++){
      int curr = arr[i];
      int prev = i-1;
      //finding out the correct postion to insert
      while(prev>=0 && arr[prev]>curr){
        arr[prev+1] = prev;
        prev--;
      }
      //Insertion
      arr[prev+1] = curr;   
    }
  }
  public static void printArr(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
     
  }
  
  public static void main(StringDemo[] args) {
    int arr[] = {5,4,1,3,2};
    Sort(arr);
    printArr(arr);
  }
  
}


