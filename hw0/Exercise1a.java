public class Exercise1a {

    public static void main(String[] args) {
        int SIZE = 5;
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

}