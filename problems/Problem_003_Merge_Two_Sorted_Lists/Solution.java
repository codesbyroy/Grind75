package Problem_003_Merge_Two_Sorted_Lists;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    /** Merges two sorted lists by relinking their existing nodes. */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode pointer = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        pointer.next = list1 != null ? list1 : list2;

        return head.next;
    }

    // Helper function to create a linked list from a list of values
    private static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to convert a linked list to an array for comparison
    private static int[] linkedListToArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    // Test cases to validate the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with two non-empty lists
        ListNode list1_1 = createLinkedList(new int[]{1, 2, 4});
        ListNode list2_1 = createLinkedList(new int[]{1, 3, 4});
        ListNode result1 = solution.mergeTwoLists(list1_1, list2_1);
        assert java.util.Arrays.equals(linkedListToArray(result1), new int[]{1, 1, 2, 3, 4, 4}) : "Test Case 1 Failed";

        // Test Case 2: Both lists are empty
        ListNode list1_2 = createLinkedList(new int[]{});
        ListNode list2_2 = createLinkedList(new int[]{});
        ListNode result2 = solution.mergeTwoLists(list1_2, list2_2);
        assert java.util.Arrays.equals(linkedListToArray(result2), new int[]{}) : "Test Case 2 Failed";

        // Test Case 3: One list is empty
        ListNode list1_3 = createLinkedList(new int[]{});
        ListNode list2_3 = createLinkedList(new int[]{0});
        ListNode result3 = solution.mergeTwoLists(list1_3, list2_3);
        assert java.util.Arrays.equals(linkedListToArray(result3), new int[]{0}) : "Test Case 3 Failed";

        // Test Case 4: Lists with different lengths
        ListNode list1_4 = createLinkedList(new int[]{1, 3, 5});
        ListNode list2_4 = createLinkedList(new int[]{2, 4, 6, 8, 10});
        ListNode result4 = solution.mergeTwoLists(list1_4, list2_4);
        assert java.util.Arrays.equals(linkedListToArray(result4), new int[]{1, 2, 3, 4, 5, 6, 8, 10}) : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
