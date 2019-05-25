public class BubbleSort {
    public static int[] sort(int[] arrs){
        for (int i = 0 ; i<arrs.length-1 ; i++){
            for (int j = 0 ; j<arrs.length-1-i; j++){
                if (arrs[j]>arrs[j+1]){
                    int tmp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = tmp;
                }
            }
        }
        return arrs;
    }
}
