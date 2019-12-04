package test.basetest;

public class IndexOfTest {

	public static void main(String[] args) {
		char[] source = new char[]{'a','b','c','d'};
		char[] target = new char[]{'c','d'};
		System.out.println(findindex(source, target, 0));
	}
	
	public static int findindex(char[] source,char[] target,int fromIndex){
		char first = target[0];
		int sourceCount= source.length;
		int targetCount = target.length;
		int sourceOffset = 0;
		int targetOffset = 0;
        int max = 0 + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. 首先循环找到target首元素所在source的位置*/
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 然后循环判断target里所有元素是否依次在source中*/
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);//感觉可以换成k<targetCount

                if (j == end) {//感觉可以换成k==targetCount
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
	}
}