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
        ListNode newN = ReverseList(head.next);//一直循环到链尾
        head.next.next = head;//不可以使用newN指向head，因为newH一直指向链尾，
        // 刚开始时head是4，newN是5，这里便是，5指向4，然后让4指向null，向外一层递归时head是3了，newH还是5,4指向3,3指向null。。。
        head.next = null;
        return newN;
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
