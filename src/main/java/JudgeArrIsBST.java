public class JudgeArrIsBST {
    //判断一个数组是不是二叉搜索树的后序遍历
    public static boolean judge(int[] a, int len){
        if (a == null || len < 0){
            return false;
        }

        int root = a[len-1];
        int i = 0;
        while (a[i] < root){
            i++;
        }

        int j =i;
        while (j < len -1 ){
            if (a[j]<root){
                return false;
            }
            j++;
        }

        boolean left = true;

        if (i>0){
            int[] aleft = new int[i];
            for (int x = 0 ; x< i; x++){
                aleft[x] = a[x];
            }
            left = judge(aleft,i);
        }

        boolean right = true;
        if (i<len-1){
            int[] aright = new int[len-1-i];
            for (int y = 0; y<len-i-1; y++){
                aright[y] = a[len-i-1];
            }
            right = judge(aright, len-1-i);
        }
        return left&&right;
    }
}
