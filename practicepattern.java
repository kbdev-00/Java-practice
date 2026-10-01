import java.util.Scanner;

public class practicepattern {
  public static void main(String[] args) {
    int n;

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    char ch = 'a';
    int num = 1;
    int mid = n / 2;
    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= n * 2; j++) {
        if (i >= j) {

          System.out.print("  ");

        } else if (i + j > n * 2 + 1) {
          System.out.print("  ");
        } else {
          System.out.print("* ");
        }

      }

      System.out.println();

    }
  }
}
