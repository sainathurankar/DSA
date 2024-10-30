package leetcode.veryeasy;

//https://leetcode.com/problems/add-two-numbers/

import java.util.List;

public class Add2Numbers {
    public static void main(String[] args) {
//        print(new Add2Numbers().addTwoNumbers(buildListNode(List.of(2, 4, 3)), buildListNode(List.of(5, 6, 4))));
        print(new Add2Numbers().addTwoNumbers(buildListNode(List.of(2,4,9)), buildListNode(List.of(5,6,4,9))));
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    private static ListNode buildListNode(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        ListNode cur = head;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        String str1 = sb1.reverse().toString();
        String str2 = sb2.reverse().toString();

        System.out.println(str1);
        System.out.println(str2);

        long sum = Long.parseLong(str1) + Long.parseLong(str2);
        

        System.out.println(sum);
        String sumStr = String.valueOf(sum);

        ListNode head = result;
        for (int i = sumStr.length() - 1; i >= 0; i--) {
            result.val = Integer.valueOf(sumStr.substring(i,i+1));
            if (i==0) break;
            result.next = new ListNode();
            result = result.next;
        }

        return head;
    }
}


// Definition for singly-linked list.
class ListNode {
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