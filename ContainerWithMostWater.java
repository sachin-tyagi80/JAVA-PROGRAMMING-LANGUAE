////////////////////////////Two pointer opproach
import java.util.ArrayList;
import java.util.Scanner;

public class ContainerWithMostWater {
    // Two-pointer approach
    public static int maxArea(ArrayList<Integer> height) {
        int maxArea = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height.get(left), height.get(right));
            int area = width * h;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            // update pointer
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of heights: ");
        int n = sc.nextInt();

        // Input elements
        ArrayList<Integer> height = new ArrayList<>();
        System.out.println("Enter the heights:");
        for (int i = 0; i < n; i++) {
            height.add(sc.nextInt());
        }

        // Call maxArea and display result
        int result = maxArea(height);
        System.out.println("Maximum area of water container: " + result);
    }
}







//////////////////////////////////////////Bruteforce opporach
// import java.util.ArrayList;
// import java.util.Scanner;

// public class ContainerWithMostWater {
//     // Brute force approach
//     public static int maxArea(ArrayList<Integer> height) {
//         int maxArea = 0;
//         int n = height.size();

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int width = j - i;
//                 int h = Math.min(height.get(i), height.get(j));
//                 int currarea = width * h;
//                 maxArea = Math.max(maxArea, currarea);
//             }
//         }

//         return maxArea;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Input size
//         System.out.print("Enter number of heights: ");
//         int n = sc.nextInt();

//         // Input elements
//         ArrayList<Integer> height = new ArrayList<>();
//         System.out.println("Enter the heights:");
//         for (int i = 0; i < n; i++) {
//             height.add(sc.nextInt());
//         }

//         // Call maxArea and display result
//         int result = maxArea(height);
//         System.out.println("Maximum area of water container: " + result);
//     }
// }

