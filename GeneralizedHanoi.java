import java.util.*;

public class GeneralizedHanoi {

  static long[] pow2 = new long[31];

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 30; i++) {
      pow2[i] = (1L << i) - 1;
    }

    while (true) {

      int n = sc.nextInt();

      if (n == 0)
        break;

      int[] ini = readArr(sc, n);
      int[] tgt = readArr(sc, n);

      sb.append(solve(n, ini, tgt)).append('\n');
    }

    System.out.print(sb);
    sc.close();
  }

  static int[] readArr(Scanner sc, int n) {
    int[] a = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = sc.nextInt();
    }

    return a;
  }

  static long solve(int n, int[] ini, int[] tgt) {
    int k = n;

    while (k >= 1 && ini[k] == tgt[k])
      k--;

    if (k == 0)
      return 0;

    int aux = 6 - ini[k] - tgt[k];

    return moveTo(k - 1, ini, aux)
        + 1
        + fromPeg(k - 1, aux, tgt);
  }

  static long moveTo(int k, int[] pos, int dest) {

    if (k == 0)
      return 0;

    if (pos[k] == dest)
      return moveTo(k - 1, pos, dest);

    int aux = 6 - pos[k] - dest;

    long cost = moveTo(k - 1, pos, aux)
        + 1
        + pow2[k - 1];

    pos[k] = dest;

    Arrays.fill(pos, 1, k, dest);

    return cost;
  }

  static long fromPeg(int k, int src, int[] tgt) {

    if (k == 0)
      return 0;

    if (tgt[k] == src)
      return fromPeg(k - 1, src, tgt);

    return pow2[k - 1]
        + 1
        + fromPeg(k - 1, 6 - src - tgt[k], tgt);
  }
}