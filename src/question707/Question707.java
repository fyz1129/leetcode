package question707;

public class Question707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        //myLinkedList.order();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.order();
        System.out.println(myLinkedList.get(1));
        /*myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        *//*myLinkedList.order();*//*
        int i = myLinkedList.get(1);
        System.out.println("i = " + i);
        myLinkedList.deleteAtIndex(1);
        *//*myLinkedList.order();*//*
        int i1 = myLinkedList.get(1);
        System.out.println("i1 = " + i1);*/
    }

}

class MyLinkedList {
    ListNode head;

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(){

        }

        public ListNode(int val){
            this(val, null);
        }

        public ListNode(ListNode next){
            this(0, next);
        }


        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {

    }

    public MyLinkedList(ListNode head){
        this.head = head;
    }

    public int get(int index) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null && index >= 0){
            cur = cur.next;
            index--;
        }
        return cur == null? -1 : cur.val;
    }

    public void addAtHead(int val) {
        head = new ListNode(val, head);
    }

    public void addAtTail(int val) {
        ListNode tail = new ListNode(val);
        if(head == null){
            head = tail;
            return;
        }
        ListNode cur = head;
        while(cur != null && cur.next != null){
            cur = cur.next;
        }
        cur.next = tail;
    }

    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        if(index <= 0){
            addAtHead(val);
            return;
        }
        if(head == null){
            return;
        }
        ListNode cur = head;
        while(cur != null && index > 1){
            cur = cur.next;
            index--;
        }
        //index大于链表长度
        if(cur == null){
            return;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public void deleteAtIndex(int index) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null){
            if(index == 0){
                cur.next = cur.next.next;
                head = dummy.next;
                return;
            }
            cur = cur.next;
            index--;
        }
    }

    public void order() {
        ListNode cur = head;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
