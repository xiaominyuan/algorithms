

public class AppMain {
    public static void main(String[] args) {
        int[] arrs = {1,4,2,7,6,10};
//        int[] result = BubbleSort.sort(arrs);
//        for (int a : arrs){
//            System.out.println(a);
//        }
        QuickSort.sort(arrs, 0 , arrs.length-1);

        for (int i : arrs){
            System.out.println(i);
        }

    }
}
