import java.util.*;

public class MeetingRooms {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of meetings
        int n = sc.nextInt();

        // 2D array to store meetings
        int[][] arr = new int[n][2];

        // Taking input
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); // Start time
            arr[i][1] = sc.nextInt(); // End time
        }

        // Sort meetings based on starting time
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        boolean canAttend = true;

        // Check for overlap
        for (int i = 1; i < arr.length; i++) {

            // If current meeting starts before previous meeting ends
            if (arr[i][0] < arr[i - 1][1]) {
                canAttend = false;
                break;
            }
        }

        System.out.println(canAttend);

        sc.close();
    }
}


// 🎤 Interview Explanation

// "I first sort the meetings by their start time. Then I compare each meeting's start time 
// with the previous meeting's end time. If the current meeting starts before the previous meeting ends, 
// the meetings overlap, so one person cannot attend all meetings. Otherwise, I continue checking.
//  If no overlap is found after traversing all meetings, I return true."