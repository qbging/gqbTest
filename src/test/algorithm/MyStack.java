package test.algorithm;

/**
 * @author guoqb
 * @date : 2019/10/17 11:11
 * @descript 单链表实现栈的出入栈（链表和数组都可以实现，但是数组(arraylist)大小固定，超出涉及搬家）
 */
public class MyStack {
    class Node{
        int value;
        Node next;
        public Node(int value,Node node){
            this.value = value;
            this.next = node;
        }
    }
    Node head = null;

    public void push(int value){
        Node node = new Node(value,null);
        if (head == null){
            head = node;
        } else {
            //栈顶移动
            node.next = head;//先
            head = node;//后
        }
    }
    public Integer pop() {
        if (null == head){
            return null;
        } else {
            //栈顶移动
            int value = head.value;
            head = head.next;
            return value;
        }
    }

    public boolean hasNext(){
        return head != null;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        while (stack.hasNext()){
            System.out.println(stack.pop());
        }
    }
}
