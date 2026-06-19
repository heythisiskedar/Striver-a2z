package binary_search_on_answers;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int high = maxPile;
        int ans = maxPile;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long th = totalHours(piles, mid);

            if (th <= h) {
                ans = mid;

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long totalHours(int[] piles, int speed) {
        long hours = 0;

        for (int num : piles) {
            hours += (int) Math.ceil((double) num / speed);
        }

        return hours;
    }
}
