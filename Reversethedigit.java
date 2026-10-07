import java.util.*;

public class Reversethedigit {
  public static int countDigits(int n) {
    if (n == 0) {
      return 1;
    }
    int count = 0;
    while (n != 0) {
      n /= 10;
      count++;

    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = sc.nextInt();
    int count = countDigits(n);
    System.out.println("number of digit present in " + n + "is : = " + count);
  }
}