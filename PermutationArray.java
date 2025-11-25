import java.util.*;

class PermutationArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // track which elements are used
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // base case: अगर current permutation complete हो गई
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // इसका एक copy save करें
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // अगर element अभी तक यूज़ नहीं हुआ
                used[i] = true; // उसे यूज़ कर रहे हैं
                current.add(nums[i]); // element को permutation में जोड़ो

                backtrack(nums, current, used, result); // recursive call

                // backtrack: वापस आओ, फिर से try करने के लिए
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    // Testing
    public static void main(String[] args) {
        PermutationArray sol = new PermutationArray();
        int[] nums = {1, 2, 3};
        List<List<Integer>> perms = sol.permute(nums);
        System.out.println(perms);
    }
}
