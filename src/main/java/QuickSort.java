
public class QuickSort {
    public static void sort(int[] arrs, int l1, int l2){
        if (l1 >= l2){
            return;
        }


        int i = l1;
        int j =l2;
        int tmp = arrs[l1];

        while (i<j){
            while (arrs[j]>=tmp && i<j){
                j--;
            }
            while (arrs[i]<=tmp && i<j){
                i++;
            }
            if (i<j){
                int a = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = a;
            }
        }

        arrs[l1] = arrs[j];
        arrs[j] = tmp;
        sort(arrs,l1,j-1);
        sort(arrs,j+1,l2);
    }
}
