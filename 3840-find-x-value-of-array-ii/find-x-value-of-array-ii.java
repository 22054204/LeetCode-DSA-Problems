class Solution {
    class Block {
        int product;
        int[] pref;

        Block() {
            pref = new int[k];
        }
    }

    int[] nums;
    Block[] blocks;
    int n, k, size;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.k = k;
        n = nums.length;

        size = (int)Math.sqrt(n) + 1;
        blocks = new Block[(n + size - 1) / size];

        build();

        int[] result = new int[queries.length];

        for(int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            nums[index] = value;
            rebuild(index / size);

            result[q] = query(start, x);
        }

        return result;
    }

    void build() {
        for(int b = 0; b < blocks.length; b++) {
            rebuild(b);
        }
    }

    void rebuild(int b) {
        blocks[b] = new Block();

        int left = b * size;
        int right = Math.min(n, left + size);

        int product = 1 % k;

        for(int i = left; i < right; i++) {
            product = (product * (nums[i] % k)) % k;

            blocks[b].pref[product]++;
        }

        blocks[b].product = product;
    }

    int query(int start, int x) {
        int[] count = new int[k];

        int product = 1 % k;
        int i = start;

        // Process elements until block boundary
        while(i < n && i % size != 0) {
            product = (product * (nums[i] % k)) % k;
            count[product]++;
            i++;
        }

        // Process complete blocks
        while(i + size <= n) {
            Block block = blocks[i / size];

            // Prefixes completely inside this block
            for(int r = 0; r < k; r++) {
                int newRem = (product * r) % k;
                count[newRem] += block.pref[r];
            }

            product = (product * block.product) % k;
            i += size;
        }

        // Process remaining elements
        while(i < n) {
            product = (product * (nums[i] % k)) % k;
            count[product]++;
            i++;
        }

        return count[x];
    }
}