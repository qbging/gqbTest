package test.ListTest;

/**
 * 单向链表，通过递归反转
 */
public class Reverse {
    static class ListNode {//静态内部类
//    class ListNode{//成员内部类
        int val;
        ListNode next = null;

        public ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode node = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4,null);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);//静态内部类时初始化方法
        ListNode listNode = Reverse.ReverseList(n1);
        System.out.println(listNode);
//        Reverse reverse = new Reverse();
//        reverse.new ListNode(1,null);//成员内部类时初始化方法
    }
}
