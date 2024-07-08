package tree;

public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = list1;
        ListNode head2 = list2;
        while (head2 != null) {
            if (head.val < head2.val) {
                if (head.next == null) {
                    head.next = head2;
                    return list1;
                }
                head = head.next;
                continue;
            }
            //head > head2
            ListNode temp = new ListNode(head.val);
            temp.next = head.next;
            head.next = temp;
            head.val = head2.val;
            head2 = head2.next;
            if (head.next == null) {
                head.next = head2;
                return list1;
            }

        }
        return list1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
