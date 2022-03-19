package jianzhioffer35;

/**
 * @author Dell
 */
public class JianZhiOffer35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        //node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        Node newHead = solution.copyRandomList(node1);
        System.out.println(newHead == node1);
        while (newHead != null){
            System.out.print(newHead.val + ",");
            if (newHead.random != null){
                System.out.print(newHead.random.val + ",");
            }
            newHead = newHead.next;
            System.out.println();
        }
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        //对每一个节点复制一遍，并将复制的节点插入原节点和其next节点之间
        if(head == null){
            return null;
        }
        Node cur = head;
        for(;cur != null; cur = cur.next.next){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
        }
        //将每一个新节点的随机节点指针指向新的随机节点
        Node newHead = head.next;
        for(cur = head; cur != null;){
            Node newNode = cur.next;
            newNode.random = cur.random == null? null : cur.random.next;
            cur.next = cur.next.next;
            newNode.next = newNode.next == null? null : newNode.next.next;
            cur = cur.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}