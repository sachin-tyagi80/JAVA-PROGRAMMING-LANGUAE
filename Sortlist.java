class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode mid = getMid(head);

        // Split
        ListNode rightHead = mid.next;
        mid.next = null;

        // Sort left and right
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Merge sorted halves
        return merge(left, right);
    }

    // Find middle node
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }
}

public class Sortlist {     
    public static void main(String[] args) {
        // Example input: [4, 2, 1, 3]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Solution solution = new Solution();
        ListNode sortedHead = solution.sortList(head);

        // Print sorted list
        printList(sortedHead);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
