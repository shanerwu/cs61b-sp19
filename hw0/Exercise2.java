public class Exercise2 {

    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int max = m[0];
        int i = 1;

        while (i < m.length) {
            if (m[i] > max) {
                max = m[i];
            }
            i++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};

        // Should print 22
        System.out.println(max(numbers));
    }

}