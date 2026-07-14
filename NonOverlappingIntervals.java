import java.util.*;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of intervals
        int n = sc.nextInt();

        // 2D array to store intervals
        int[][] nums = new int[n][2];

        // Taking input
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt(); // Start time
            nums[i][1] = sc.nextInt(); // End time
        }

        // Sort intervals based on ending time
        Arrays.sort(nums, Comparator.comparingInt(o -> o[1]));

        // Select the first interval
        int last = nums[0][1];
        int count = 1;

        // Traverse remaining intervals
        for (int i = 1; i < n; i++) {

            // If current interval does not overlap
            if (nums[i][0] >= last) {

                // Select the interval
                count++;

                // Update last selected interval's end time
                last = nums[i][1];
            }
        }

        // Minimum intervals to remove
        System.out.println("Minimum intervals to remove = " + (n - count));

        sc.close();
    }
}