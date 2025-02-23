function maxProfit(prices: number[]): number {
	let max = prices[0];
	let min = prices[0];
	let profit = 0;
	for (let i = 1; i < prices.length; i++) {
		if (prices[i] > max) {
			max = prices[i];
			profit = Math.max(profit, max - min);
		}
		if (prices[i] < min) {
			min = prices[i];
			max = prices[i];
		}
	}
	return profit;
}

export default maxProfit;
