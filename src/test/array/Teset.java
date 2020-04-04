package test.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author guoqb
 * @date : 2020/3/24 9:54
 * @descript 两个有序数组，求交并集
 */
public class Teset {

    public static void main(String[] args) {
        int[]a = {1,3,4,5,7};
        int[]b = {2,3,5,8,9};
//        char[] aa={'a','a','b'};
//        char[] bb={'a','b'};
        char[] aa={'a','b','c'};
        char[] bb={'b','c'};

        char c = find(aa, bb);
        System.out.println(c);
        List<Integer> intersection = intersection(a, b);
        System.out.println(intersection);
        List<Integer> union = union(a, b);
        System.out.println(union);

    }

    /**
     * 使用双指针方式求交集，复杂度O(n+m)，
     * 其他方法：两次遍历（o(nm)）,二分法：O(nlogm)或O(mlogn)
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> intersection(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA != A.length && pointerB != B.length) {
            if (A[pointerA] > B[pointerB]) {
                pointerB++;
            } else if (A[pointerA] < B[pointerB]) {
                pointerA++;
            } else {
                list.add(A[pointerA]);
                pointerA++;
                pointerB++;
            }
        }
        return list;
    }

    public static List<Integer> union(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < A.length && pointerB < B.length) {
            if (A[pointerA] > B[pointerB]) {
                list.add(B[pointerB]);
                pointerB++;
            } else if (A[pointerA] < B[pointerB]) {
                list.add(A[pointerA]);
                pointerA++;
            } else {
                list.add(A[pointerA]);
                pointerA++;
                pointerB++;
            }
        }
        // 退出来之后，把剩余的继续添加
        while (pointerB <= B.length - 1) {
            list.add(B[pointerB]);
            pointerB++;
        }
        while (pointerA <= A.length - 1) {
            list.add(A[pointerA]);
            pointerA++;
        }
        return list;
    }

    public static char find(char[] A, char[] B){
        int pointerA = 0;
        int pointerB = 0;
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0;i<A.length;i++){
            if (map.containsKey(A[i])){
                map.put(A[i],map.get(A[i])+1);
            } else{
                map.put(A[i],1);
            }
        }
        for (int j=0;j<B.length;j++){
            if(map.containsKey(B[j])&& map.get(B[j]) == 1){
                map.remove(B[j]);
            }
        }
        for (Character c: map.keySet()){
            return c;
        }
        return (Character)null;
//        while (pointerA < A.length && pointerB < B.length) {
//            if (A[pointerA] == B[pointerB]){
//                pointerA++;
//                pointerB++;
//            } else {
//                if (pointerB>=1 && A[pointerA] == B[pointerB-1]){
//                    return B[pointerB];
//                } else if (pointerB>=1 && A[pointerA] == B[pointerB+1]){
//                    return A[pointerA];
//                }
//            }
//        }
    }
}
