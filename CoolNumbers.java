import java.io.*;
import java.util.*;

public class CoolNumbers {

  static int[] digs;
  static Map<String, Long> memo = new HashMap<>();

  static long dp(int pos, int diff, boolean tight, boolean started, int L) {
    if (pos == L)
      return (started && diff == 0) ? 1 : 0;

    String key = pos + "," + diff + "," + (tight ? 1 : 0) + "," + (started ? 1 : 0);
    if (!tight && memo.containsKey(key))
      return memo.get(key);

    int limit = tight ? digs[pos] : 9;
    int half = L / 2;
    long res = 0;

    for (int d = (pos == 0 ? 1 : 0); d <= limit; d++) {
      boolean newTight = tight && (d == limit);
      int contrib;
      if (!started && d == 0) {
        contrib = 0;
      } else if (pos < half) {
        contrib = d;
      } else if (L % 2 == 1 && pos == half) {
        contrib = 0;
      } else {
        contrib = -d;
      }
      res += dp(pos + 1, diff + contrib, newTight, true, L);
    }

    if (!tight)
      memo.put(key, res);
    return res;
  }

  static long countUpTo(long n) {
    if (n <= 0)
      return 0;
    String s = Long.toString(n);
    int len = s.length();

    long total = 0;

    for (int L = 1; L < len; L++) {
      memo.clear();
      digs = new int[L];
      Arrays.fill(digs, 9);
      total += dp(0, 0, false, false, L);
    }

    digs = new int[len];
    for (int i = 0; i < len; i++)
      digs[i] = s.charAt(i) - '0';
    memo.clear();
    total += dp(0, 0, true, false, len);

    return total;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = br.readLine()) != null) {
      line = line.trim();
      if (line.isEmpty())
        continue;
      StringTokenizer st = new StringTokenizer(line);
      long A = Long.parseLong(st.nextToken());
      long B = Long.parseLong(st.nextToken());
      if (A == 0 && B == 0)
        break;
      System.out.println(countUpTo(B) - countUpTo(A - 1));
    }
  }
}