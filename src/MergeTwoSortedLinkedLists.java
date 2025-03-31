import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int nums1[] = {1, 2, 4};
        int nums2[] = {1, 3, 4};

        LinkedListNode list1 = buildList(nums1);
        LinkedListNode list2 = buildList(nums2);

        printList(mergeTwoLists(list1, list2));

    }

    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode curr = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static LinkedListNode buildList(int[] nums) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode current = dummy;
        for(int num : nums) {
            current.next = new LinkedListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.val + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
}


