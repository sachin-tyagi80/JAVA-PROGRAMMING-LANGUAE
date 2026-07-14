import java.util.ArrayList;
public class ActivitySelection {
  public static void main(String[] args) {
    int start[] = {1,3,0,5,8,5};
    int end[] = {2,4,6,7,9,9};

    //end time basis sorted
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    
    //1st activity
    maxAct = 1;
    ans.add(0);
    int lastEnd = end[0];
  
    for(int i=1;i<end.length;i++){
      if(start[i]>=lastEnd){
        //activity selected
        maxAct++;
        ans.add(i);
        lastEnd = end[i];
      }  
    }
    System.out.println("Maximum activities selected: " + maxAct);
    System.out.println("Selected activities (indices): " + ans);
  }
  
}







// import java.util.*;

// public class ActivitySelection {

//     // Activity class
//     static class Activity {
//         int start;
//         int finish;

//         Activity(int start, int finish) {
//             this.start = start;
//             this.finish = finish;
//         }
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         // Number of activities
//         System.out.print("Enter number of activities: ");
//         int n = sc.nextInt();

//         Activity[] activities = new Activity[n];

//         // Input start and finish time
//         System.out.println("Enter start time and finish time:");

//         for (int i = 0; i < n; i++) {
//             int start = sc.nextInt();
//             int finish = sc.nextInt();

//             activities[i] = new Activity(start, finish);
//         }

//         // Sort activities based on finish time
//         Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

//         // Select first activity
//         int count = 1;
//         int lastFinish = activities[0].finish;

//         System.out.println("\nSelected Activities:");
//         System.out.println("(" + activities[0].start + ", " + activities[0].finish + ")");

//         // Traverse remaining activities
//         for (int i = 1; i < n; i++) {

//             // If current activity starts after last selected activity finishes
//             if (activities[i].start > lastFinish) {

//                 // Select current activity
//                 count++;

//                 System.out.println("(" + activities[i].start + ", " + activities[i].finish + ")");

//                 // Update last finish time
//                 lastFinish = activities[i].finish;
//             }
//         }

//         System.out.println("\nMaximum Activities = " + count);

//         sc.close();
//     }
// }



// I first store each activity as a pair of start and finish times. Then I sort all activities by their finish time because choosing the activity
// that finishes earliest leaves the maximum time for future activities. I always select the first activity, 
// then iterate through the remaining activities. If the current activity starts after the last selected activity finishes, 
// I select it and update the last finish time. This greedy strategy gives the maximum number of non-overlapping activities."
