package jianzhioffer.jianzhioffer25;

/**
 * @author Dell
 */
public class JianZhiOffer25 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(-9);
        ListNode l2 = new ListNode(3);
        //ListNode l3 = new ListNode(4);
        l1.next = l2;
        //l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(7);
        //ListNode l6 = new ListNode(4);
        l4.next = l5;
        //l5.next = l6;
        ListNode listNode = solution.mergeTwoLists(l1, l4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while(l1 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        System.out.println(l2.val);
        while(l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}

class ListNode {
     int val;
     ListNode next;

    public ListNode() {
    }

    ListNode(int x) { val = x; }
}
