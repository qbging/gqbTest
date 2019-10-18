package test.sort;

/**
 * @author guoqb
 * @date : 2019/10/15 18:11
 * @descript
 */
public class insert {
    public static void main(String[] args) {
        int [] ints = {7,3,8,2,1,9,4,5};
        // i:1到最后
        for(int i=1;i<ints.length;i++){
            if (ints[i]<ints[i-1]){//找需要插入的值
                // j:0到i-1
                for (int j=0;j<=i-1;j++){
                    if (ints[i]<ints[j]){//找到插入的位置
                        int temp = ints[i];
                        //k:i-1到j 倒序
                        for (int k=i-1;k>=j;k--){
                            ints[k+1] = ints[k];//向后移动
                        }
                        ints[j] = temp;
                        break;
                    }
                }
            }
        }
        for(int i=1;i<ints.length;i++){
            System.out.print(ints[i]);
        }
    }
}
