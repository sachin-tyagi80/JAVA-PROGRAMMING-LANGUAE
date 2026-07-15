import java.util.*;

public class MaxiMeetingRooms {

    // Meeting class
    static class Meeting {
        int start;
        int finish;
        int index;

        Meeting(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of meetings
        System.out.print("Enter number of meetings: ");
        int n = sc.nextInt();

        int[] start = new int[n];
        int[] finish = new int[n];

        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        System.out.println("Enter finish times:");
        for (int i = 0; i < n; i++) {
            finish[i] = sc.nextInt();
        }

        Meeting[] meetings = new Meeting[n];

        // Store meeting details
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], finish[i], i + 1);
        }

        // Sort by finish time
        // If finish time is same, smaller index first
        Arrays.sort(meetings, (a, b) -> {

            if (a.finish == b.finish) {
                return a.index - b.index;
            }

            return a.finish - b.finish;
        });

        ArrayList<Integer> ans = new ArrayList<>();

        // Select first meeting
        ans.add(meetings[0].index);

        int lastFinish = meetings[0].finish;

        // Traverse remaining meetings
        for (int i = 1; i < n; i++) {

            // If current meeting starts after previous meeting finishes
            if (meetings[i].start > lastFinish) {

                ans.add(meetings[i].index);

                lastFinish = meetings[i].finish;
            }
        }

        // Return indices in increasing order
        Collections.sort(ans);

        System.out.println("Selected Meetings = " + ans);

        sc.close();
    }
}




// "I use the Greedy strategy. First, I create a meeting object containing start time, finish time, and original index.
// Then I sort meetings by finish time because selecting the earliest finishing meeting leaves maximum time for 
// future meetings. If two meetings finish at the same time, I choose the smaller index as required. 
// I always select the first meeting and then greedily select every meeting whose start time is strictly greater 
// than the finish time of the last selected meeting. Finally, I sort the selected indices in increasing order 
// before returning them."