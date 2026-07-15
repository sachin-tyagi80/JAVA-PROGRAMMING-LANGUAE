import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {

        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];

        // 0th column = index
        // 1st column = value/weight ratio
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sort in ascending order of ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalValue = 0;

        // Traverse from highest ratio to lowest ratio
        for (int i = ratio.length - 1; i >= 0; i--) {

            int idx = (int) ratio[i][0];

            if (capacity >= weight[idx]) {
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {
                finalValue += ratio[i][1] * capacity;
                break;
            }
        }

        System.out.println("Maximum Value = " + finalValue);
    }
}

/////////////////////////////////////////////////////////////////////////////////
// In Fractional Knapsack, I calculate the value-to-weight ratio for each item and sort the items in descending
// order of this ratio. Then I pick the highest-ratio items first. If an item fits completely, 
// I take it; otherwise, I take only the fraction that fits. Since fractions are allowed, choosing the highest 
// value per unit weight at each step guarantees the maximum total value, making Greedy the optimal approach."

///////////////////////////////////////////////////////////////////////////////////////
// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of items: ");
//         int n = sc.nextInt();

//         int val[] = new int[n];
//         int weight[] = new int[n];

//         System.out.println("Enter values:");
//         for (int i = 0; i < n; i++) {
//             val[i] = sc.nextInt();
//         }

//         System.out.println("Enter weights:");
//         for (int i = 0; i < n; i++) {
//             weight[i] = sc.nextInt();
//         }

//         System.out.print("Enter knapsack capacity: ");
//         int W = sc.nextInt();

//         double ratio[][] = new double[n][2];

//         // 0th column = index
//         // 1st column = value/weight ratio
//         for (int i = 0; i < n; i++) {
//             ratio[i][0] = i;
//             ratio[i][1] = val[i] / (double) weight[i];
//         }

//         // Sort in ascending order of ratio
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity = W;
//         double finalValue = 0;

//         // Traverse from highest ratio to lowest ratio
//         for (int i = n - 1; i >= 0; i--) {

//             int idx = (int) ratio[i][0];

//             if (capacity >= weight[idx]) {
//                 finalValue += val[idx];
//                 capacity -= weight[idx];
//             } else {
//                 finalValue += ratio[i][1] * capacity;
//                 break;
//             }
//         }

//         System.out.println("Maximum Value = " + finalValue);

//         sc.close();
//     }
// }