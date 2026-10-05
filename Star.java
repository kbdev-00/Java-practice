
import java.util.*;

class Star {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = n * 2 - 1;

        for (int i = 1; i <= n; i++) {

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            // increasing
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // decreasing
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}