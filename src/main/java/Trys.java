public class Trys {

    public void put(int[] arr, int b){
        for (int i =0; i<arr.length; i++){
            if (arr[i] == 66){
                arr[i] = b;
                return;
            }
            arr[i] = b;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,66,8,0};
        int b = 7;
        Trys trys = new Trys();
        trys.put(a,b);
        for (int s : a){
            System.out.println(s);
        }
    }
}
