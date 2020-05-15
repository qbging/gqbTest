package test.list;

import java.util.LinkedList;

/**
 * @author guoqb
 * @date : 2020/2/24 10:40
 * @descript push 和 pop(null时抛异常) 表示栈Stack操作
 *          注意offer和poll是队列操作 FIFO
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
//        System.out.println(list.getFirst());//1
//        System.out.println(list.getLast());//3
//        System.out.println(list.peek());//1
//        System.out.println(list.element());//1
//        System.out.println(list.poll());//1
//        System.out.println(list.pollLast());//3
//        System.out.println(list.pop());//1
//        System.out.println(list.remove());//1
        LinkedList list1 = new LinkedList();
        list1.push(1);//addFirst
        list1.push(2);
        list1.push(3);
        System.out.println(list1.pop());//3       注意push 和 pop(null时抛异常) 表示栈Stack操作（FILO），此时linkedlist(其实是FIFO)用作栈
//        System.out.println(list1.getFirst());//3      注意**
//        System.out.println(list1.getLast());//1       注意**
//        System.out.println(list1.peek());//3      注意**
//        System.out.println(list1.element());//3       注意**
//        System.out.println(list1.poll());//3        注意**
//        System.out.println(list1.pollLast());//1      注意**
//        System.out.println(list1.remove());//3        注意**
        LinkedList list2 = new LinkedList();
        list2.offer(1);
        list2.offer(2);
        list2.offer(3);
        System.out.println(list2.poll());//1    注意offer和poll是队列操作 FIFO
//        System.out.println(list2.getFirst());//1      注意**
//        System.out.println(list2.getLast());//3      注意**
//        System.out.println(list2.peek());//1  注意**
//        System.out.println(list2.element());//1      注意**
//        System.out.println(list2.pollLast());//3      注意**
//        System.out.println(list2.pop());//1  注意**
//        System.out.println(list2.remove());//1      注意**
    }
}
