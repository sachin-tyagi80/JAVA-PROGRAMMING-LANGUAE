import java.util.Arrays;
// 2 pointer apporach TC => o(n)
class TwoSum {
    boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);  // Sort the array
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        int[] arr = {2, 7, 11, 15};  // Example input array
        int target = 9;             // Example target

        boolean result = sol.twoSum(arr, target);
        System.out.println("Is there a pair with the target sum? " + result);
    }
}



//////////////////////brute force opporach Tc => o(n2)
// class TwoSum {
//     boolean twoSum(int arr[], int target) {
//         // code here
//         int n = arr.length;
//         for(int i=0;i<n-1;i++){
//             for(int j = i+1;j<n;j++){
//                 if(arr[i] + arr[j] == target){
//                     return true;
//                 }
                
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//       TwoSum sol = new TwoSum();

//       int[] arr = {2, 7, 11, 15};  // Example input array
//       int target = 50;             // Example target

//       boolean result = sol.twoSum(arr, target);
//       System.out.println("Is there a pair with the target sum? " + result);
//     }
// }


