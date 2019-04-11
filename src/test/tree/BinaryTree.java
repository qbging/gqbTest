package test.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**                     1
 * 遍历二叉树      2             3
 *           4      5       6      7
 *                8   9
 *                     10
 */
public class BinaryTree {

    //前序遍历递归的方式
    public void preOrder(BinaryTreeNode root){
        if(null!=root){
            System.out.print(root.data+"\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    //前序遍历非递归的方式
    public void preOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                System.out.print(root.data+"\t");
                stack.push(root);
                root=root.left;
            }
            if(stack.isEmpty()) break;
            root=stack.pop();
            root=root.right;
        }
    }
    
    //中序遍历采用递归的方式
    public void inOrder(BinaryTreeNode root){
        if(null!=root){
            inOrder(root.left);
            System.out.print(root.data+"\t");
            inOrder(root.right);
        }
    }
    
    //中序遍历采用非递归的方式
    public void inOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(stack.isEmpty())break;
            root=stack.pop();
            System.out.print(root.data+"\t");
            root=root.right;
        }
    }
    
    //后序遍历采用递归的方式
    public void postOrder(BinaryTreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+"\t");
        }
    }
    
    //后序遍历采用非递归的方式
    public void postOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                if(stack.isEmpty()) return;
                
                if(null==stack.lastElement().right){
                    root=stack.pop();
                    System.out.print(root.data+"\t");
                    while(root==stack.lastElement().right){
                        System.out.print(stack.lastElement().data+"\t");
                        root=stack.pop();
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                
                if(!stack.isEmpty())
                    root=stack.lastElement().right;
                else
                    root=null;
            }
        }
    }

    //层序遍历
    public void levelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp=queue.poll();
            System.out.print(temp.data+"\t");
            if(null!=temp.left) 
                queue.offer(temp.left);
            if(null!=temp.right){
                queue.offer(temp.right);
            }
        }
    }
    

}