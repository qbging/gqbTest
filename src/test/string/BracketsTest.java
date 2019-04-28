package test.string;

import java.util.Stack;

/**
 * 括号正对 匹配测试
 */
public class BracketsTest {
    public static void main(String[] args) {
        String string = "12(21(3))(1(13)(345))";
        boolean valid = new BracketsTest().isValid(string);
        System.out.println(string+"括号是否成对："+valid);
    }
    public boolean isValid(String s){
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')
                stack.push(c);
            else if (c==')'){
                if (stack.peek()=='(')
                stack.pop();
            } else{
                continue;
            }
        }
        return stack.isEmpty();
    }
}
