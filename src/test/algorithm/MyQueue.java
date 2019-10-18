package test.algorithm;

/**
 * @author guoqb
 * @date : 2019/10/17 11:11
 * @descript 单链表实现队列的FIFO，只是多了一个队尾指针（数组(arraylist)实现效率不高，FO时会涉及数组后面的移动）
 */
public class MyQueue {
    class Node{
        int value;
        Node next;
        public Node(int value,Node node){
            this.value = value;
            this.next = node;
        }
    }
    Node head = null;
    Node foot = null;

    public void push(int value){
        Node node = new Node(value,null);
        if (head == null){
            head = node;
            foot = node;
        } else {
            //队尾移动
            foot.next = node;//先
            foot = node;//后
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
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        while (queue.hasNext()){
            System.out.println(queue.pop());
        }
    }
}
