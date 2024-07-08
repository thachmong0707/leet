package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> rs = new ArrayList<>();
        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        rs.add(nums1[i]);
                        nums2[j] = -1;
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i] == nums1[j]) {
                        rs.add(nums2[i]);
                        nums1[j] = -1;
                        break;
                    }
                }
            }
        }
        int[] s = new int[rs.size()];
        for (int i = 0; i < rs.size(); i++) {
            s[i] = rs.get(i);
        }
        return s;
    }

    public int[] intersectV2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums2) {
            counts.merge(i, 1, Integer::sum);
        }
        List<Integer> rs = new ArrayList<>();
        for (int i : nums1) {
            if (counts.containsKey(i)) {
                Integer count = counts.get(i);
                if (count <= 0) {
                    continue;
                }
                rs.add(i);
                count--;
                counts.put(i, count);
            }
        }
        int[] s = new int[rs.size()];
        for (int i = 0; i < rs.size(); i++) {
            s[i] = rs.get(i);
        }
        return s;
    }

    public int[] intersectV3(int[] nums1, int[] nums2) {
        int[] counts = new int[1001];
        for (int i : nums2) {
            counts[i]++;
        }
        int size = 0;
        Node head = new Node(-1);
        Node cursor = head;
        for (int i : nums1) {
            int count = counts[i];
            if (count <= 0) {
                continue;
            }
            size++;
            cursor.val = i;
            cursor.next = new Node();
            cursor = cursor.next;
            count--;
            counts[i] = count;
        }
        int[] s = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = head.val;
            head = head.next;
        }
        return s;
    }

    public class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
