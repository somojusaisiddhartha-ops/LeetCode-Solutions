
class Solution {
    static final long MOD = 1_000_000_007L;

    int n;
    long[] bit1, bit2;

    void add(long[] bit, int i, long val) {
        while (i <= n) {
            bit[i] += val;
            i += i & -i;
        }
    }

    long query(long[] bit, int i) {
        long sum = 0;

        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }

        return sum;
    }

    void update(int l, int r) {
        add(bit1, l, 1);
        add(bit1, r + 1, -1);

        add(bit2, l, (long) l - 1);
        add(bit2, r + 1, -(long) r);
    }

    long prefixSum(int i) {
        return query(bit1, i) * i - query(bit2, i);
    }

    long rangeSum(int l, int r) {
        if (l > r) return 0;
        return prefixSum(r) - prefixSum(l - 1);
    }

    public int sumCounts(int[] nums) {
        n = nums.length;
        bit1 = new long[n + 2];
        bit2 = new long[n + 2];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long totalSquare = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 2;
            int r = i + 1;

            long oldSum = rangeSum(l, r);
            long len = r - l + 1L;

            totalSquare = (totalSquare
                    + 2 * oldSum + len) % MOD;

            update(l, r);
            ans = (ans + totalSquare) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }
}
