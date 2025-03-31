import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        LinkedListNode lists[] = new LinkedListNode[3];

        lists[0] = buildList(new int[]{1, 4, 5});
        lists[1] = buildList(new int[]{1, 3, 4});
        lists[2] = buildList(new int[]{2, 6});

        printList(mergeKLists(lists));
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

    public static LinkedListNode mergeKLists(LinkedListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<LinkedListNode> queue =
                new PriorityQueue<>(lists.length, (a, b) -> a.val-b.val);

        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode tail = dummy;

        for(LinkedListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if(tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }
}

