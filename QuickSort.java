public class QuickSort {
   public static void printArr(int arr[]){
    for(int i =0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
  public static void quicSort(int arr[],int si ,int ei){
    if(si >= ei){
      return;
    }
    //last element
    int pIdx = partition(arr,si,ei);
    quicSort(arr, si, pIdx-1); // left
    quicSort(arr, pIdx+1, ei);
  }
  
  public static int partition(int arr[] , int si,int ei ){
    int pivot = arr[ei];
    int i = si-1; // to make place for els smaller than pivot

    for(int j=si;j<ei;j++){
      if(arr[j] <= pivot){
      i++;
      //swap
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
      }
    }
    i++;
    int temp = arr[ei];
    arr[ei] = arr[i]; // pivot = arr[i]
    arr[i] = temp;
    return i;
  }

  public static void main(String[] args) {
    int arr[] = {6,3,9,8,2,5};
    quicSort(arr, 0, arr.length-1);
    printArr(arr);
  }
  
}
