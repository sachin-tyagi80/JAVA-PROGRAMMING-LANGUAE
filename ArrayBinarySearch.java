import java.util.*;
public class ArrayBinarySearch {
  public static int binarySearch(int nums[] , int key){
     int start = 0,end = nums.length-1;
     while(start<=end){
      int mid = (start+end)/2;

      //comparsion
      if(nums[mid] == key){ // found
        return mid;
      }
      if(nums[mid] < key){  // right
        start = mid + 1;
      }else{
        end = mid-1;
      }
     }
     return -1;
  }
  public static void main(StringDemo[] args) {
    int nums[] = {2,4,6,8,10,12,14};
    int key = 10;
    System.out.println("Index for key is:"+binarySearch(nums, key));
  }
  
}
