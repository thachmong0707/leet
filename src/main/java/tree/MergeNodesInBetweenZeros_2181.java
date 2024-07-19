package tree;

public class MergeNodesInBetweenZeros_2181 extends BaseListNode {
    public ListNode mergeNodes(ListNode head) {
        ListNode cursor = head;
        while (cursor != null && cursor.next != null) {
            if (cursor.val == 0) {
                sumNode(cursor, cursor.next);

            }
            cursor = cursor.next;
        }
        return head;
    }

    private void sumNode(ListNode currentNode, ListNode list) {
        while (list != null) {
            if (list.val == 0) {
                if (list.next == null) {
                    //end of list
                    currentNode.next = null;
                    currentNode = null;
                    return;
                }
                currentNode = list;
                return;
            }
            currentNode.val += list.val;
            currentNode.next = list.next;
            list = list.next;
        }
    }

}
