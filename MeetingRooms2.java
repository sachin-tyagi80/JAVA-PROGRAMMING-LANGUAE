import java.util.*;

public class MeetingRooms2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of meetings
        System.out.print("Enter number of meetings: ");
        int n = sc.nextInt();

        int[] start = new int[n];
        int[] end = new int[n];

        // Input start times
        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        // Input end times
        System.out.println("Enter end times:");
        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }

        // Sort start and end times
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int maxRooms = 0;

        int i = 0; // Pointer for start[]
        int j = 0; // Pointer for end[]

        // Traverse all meetings
        while (i < n) {

            // New meeting starts before the earliest meeting ends
            if (start[i] < end[j]) {

                // Allocate a new room
                rooms++;

                // Update maximum rooms required
                maxRooms = Math.max(maxRooms, rooms);

                i++;
            } else {

                // One meeting has finished, room becomes free
                rooms--;
                j++;
            }
        }

        System.out.println("\nMinimum Meeting Rooms Required = " + maxRooms);

        sc.close();
    }
}