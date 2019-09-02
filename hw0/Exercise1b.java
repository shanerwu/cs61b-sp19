public class Exercise1b {

    public static void drawTriangle(int N) {
        int SIZE = N;
        int row = 0;

        while (row < SIZE) {
            int asteriskCount = 0;

            while (asteriskCount <= row) {
                System.out.print("*");
                asteriskCount++;
            }

            System.out.println();
            row++;
        }
    }

    public static void main(String[] args) {
        drawTriangle(10);
    }

}