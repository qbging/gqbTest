package test.ListTest;

/**
 * 单向链表，通过迭代反转
 */
public class Reverse1 {
    static class ListNode {//静态内部类
//    class ListNode{//成员内部类
        int val;
        ListNode next = null;

        public ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //迭代方式
    public static ListNode ReverseList(ListNode head) {
        ListNode newN = null;
        ListNode curN = head;
        while (curN!=null){
            ListNode tmp = curN.next;
            curN.next = newN;
            newN = curN;//新指针向后移动
            curN = tmp;//当前指针向后移动
        }

        return newN;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4,null);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);//静态内部类时初始化方法
        ListNode listNode = Reverse1.ReverseList(n1);
        System.out.println(listNode);
//        Reverse reverse = new Reverse();
//        reverse.new ListNode(1,null);//成员内部类时初始化方法
    }
}
