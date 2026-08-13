class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var prices = new int[n];
        for (int j = 0; j < n; j++) {
            prices[j] = Integer.MAX_VALUE;
        }
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            var tmpPrices = new int[n];
            for (int j = 0; j < n; j++) {
                tmpPrices[j] = prices[j];
            }
            for (int j = 0; j < flights.length; j++) {
                var from = flights[j][0];
                var to = flights[j][1];
                var cost = flights[j][2];
                if (prices[from] != Integer.MAX_VALUE) {
                    if (prices[from] + cost < tmpPrices[to]) {
                        tmpPrices[to] = prices[from] + cost;
                    }
                }
            }
            prices = tmpPrices;
        }
        if (prices[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return prices[dst];
    }
}
