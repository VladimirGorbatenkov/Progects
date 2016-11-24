
public class Program {
    public static int[] arr = {123, 246, 88824, 402, 276, 864};
    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++ ) {
            String st = String.valueOf(arr[i]);
            int r = 0;
            for (int j = 0; j < st.length(); j++) {
                r += Integer.parseInt(st.substring(j, j+1)) % 2;
            }
            if (r == 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
