import java.util.*;

public class sumOFthedigit {
  public static int Sumofthedigit(int n) {
    int sum = 0;
    while (n != 0) {
      sum = sum + (n % 10);
      n /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = sc.nextInt();
    int sum = Sumofthedigit(n);
    System.out.println("Sum of digits in " + n + " is : = " + sum);
  }
}
