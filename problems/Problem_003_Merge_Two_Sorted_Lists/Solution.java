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
    /**
     * PROBLEM: Merge two sorted linked lists into one sorted list
     *
     * KEY INSIGHTS:
     * - Both input lists are already sorted in ascending order
     * - Need to maintain sorted order in result
     * - Handle edge cases: empty lists, different lengths
     *
     * ALGORITHM:
     * 1. Use dummy head to simplify list construction
     * 2. Compare current nodes from both lists
     * 3. Add smaller value to result, advance that pointer
     * 4. Append remaining nodes when one list is exhausted
     *
     * :param list1: ListNode - Head of the first sorted linked list
     * :param list2: ListNode - Head of the second sorted linked list
     * :return: ListNode - Head of the merged sorted linked list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // APPROACH: Two-pointer technique with dummy head
        // TIME: O(m + n), SPACE: O(1) - only creating new nodes for comparison

        // Create dummy head to simplify edge cases (avoids checking if result is empty)
        ListNode head = new ListNode();
        ListNode pointer = head;  // Current position in the result list

        // Compare nodes from both lists while both have remaining elements
        while (list1 != null && list2 != null) {
            ListNode newNode = new ListNode();  // Create new node for result

            // Choose smaller value (maintain sorted order)
            if (list1.val <= list2.val) {
                newNode.val = list1.val;
                list1 = list1.next;  // Move to next node in list1
            } else {
                newNode.val = list2.val;
                list2 = list2.next;  // Move to next node in list2
            }

            // Link new node to result and advance pointer
            pointer.next = newNode;
            pointer = pointer.next;
        }

        // Append remaining nodes (one list is exhausted, other may have elements)
        // No need to create new nodes - just link remaining portion
        if (list1 != null) {
            pointer.next = list1;  // Attach rest of list1
        } else if (list2 != null) {
            pointer.next = list2;  // Attach rest of list2
        }

        // Return actual head (skip dummy node)
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