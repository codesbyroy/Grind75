from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    """
    PROBLEM: Merge two sorted linked lists into one sorted list
    
    KEY INSIGHTS:
    - Both input lists are already sorted in ascending order
    - Need to maintain sorted order in result
    - Handle edge cases: empty lists, different lengths
    
    ALGORITHM:
    1. Use dummy head to simplify list construction
    2. Compare current nodes from both lists
    3. Add smaller value to result, advance that pointer
    4. Append remaining nodes when one list is exhausted
    
    :param list1: Optional[ListNode] - Head of the first sorted linked list
    :param list2: Optional[ListNode] - Head of the second sorted linked list
    :return: Optional[ListNode] - Head of the merged sorted linked list
    """
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # APPROACH: Two-pointer technique with dummy head
        # TIME: O(m + n), SPACE: O(1) - only creating new nodes for comparison
        
        # Create dummy head to simplify edge cases (avoids checking if result is empty)
        head = ListNode()
        pointer = head  # Current position in the result list

        # Compare nodes from both lists while both have remaining elements
        while list1 and list2:
            new_node = ListNode()  # Create new node for result
            
            # Choose smaller value (maintain sorted order)
            if list1.val <= list2.val:
                new_node.val = list1.val
                list1 = list1.next  # Move to next node in list1
            else:
                new_node.val = list2.val
                list2 = list2.next  # Move to next node in list2
            
            # Link new node to result and advance pointer
            pointer.next = new_node
            pointer = pointer.next
        
        # Append remaining nodes (one list is exhausted, other may have elements)
        # No need to create new nodes - just link remaining portion
        if list1:
            pointer.next = list1  # Attach rest of list1
        elif list2:
            pointer.next = list2  # Attach rest of list2
        
        # Return actual head (skip dummy node)
        return head.next
       

# Test cases to validate the solution
if __name__ == "__main__":
    solution = Solution()
    
    # Helper function to create a linked list from a list of values
    def create_linked_list(values):
        if not values:
            return None
        head = ListNode(values[0])
        current = head
        for val in values[1:]:
            current.next = ListNode(val)
            current = current.next
        return head
    
    # Helper function to convert a linked list to a list for comparison
    def linked_list_to_list(head):
        result = []
        current = head
        while current:
            result.append(current.val)
            current = current.next
        return result
    
    # Test Case 1: Basic case with two non-empty lists
    list1_1 = create_linked_list([1, 2, 4])
    list2_1 = create_linked_list([1, 3, 4])
    result1 = solution.mergeTwoLists(list1_1, list2_1)
    assert linked_list_to_list(result1) == [1, 1, 2, 3, 4, 4], "Test Case 1 Failed"
    
    # Test Case 2: Both lists are empty
    list1_2 = create_linked_list([])
    list2_2 = create_linked_list([])
    result2 = solution.mergeTwoLists(list1_2, list2_2)
    assert linked_list_to_list(result2) == [], "Test Case 2 Failed"
    
    # Test Case 3: One list is empty
    list1_3 = create_linked_list([])
    list2_3 = create_linked_list([0])
    result3 = solution.mergeTwoLists(list1_3, list2_3)
    assert linked_list_to_list(result3) == [0], "Test Case 3 Failed"
    
    # Test Case 4: Lists with different lengths
    list1_4 = create_linked_list([1, 3, 5])
    list2_4 = create_linked_list([2, 4, 6, 8, 10])
    result4 = solution.mergeTwoLists(list1_4, list2_4)
    assert linked_list_to_list(result4) == [1, 2, 3, 4, 5, 6, 8, 10], "Test Case 4 Failed"
    
    # All tests passed message
    print("All test cases passed!")