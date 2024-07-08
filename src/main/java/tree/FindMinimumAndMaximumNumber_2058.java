package tree;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumAndMaximumNumber_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] rs = new int[2];
        int before = head.val;
        ListNode cursor = head.next;
        List<Integer> targets = new ArrayList<>();
        int i = 2;
        while (cursor.next != null) {
            if (before < cursor.val && cursor.val > cursor.next.val) {
                targets.add(i);
            } else if (before > cursor.val && cursor.val < cursor.next.val) {
                targets.add(i);
            }
            before = cursor.val;
            cursor = cursor.next;
            i++;
        }
        if (targets.size() < 2) {
            rs[0] = -1;
            rs[1] = -1;
            return rs;
        }
        int max = targets.get(targets.size() - 1) - targets.get(0);
        int min = max;

        for (int j = 1; j < targets.size(); j++) {
            min = Math.min(min, targets.get(j) - targets.get(j - 1));
        }
        rs[0] = min;
        rs[1] = max;
        return rs;
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
