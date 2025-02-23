import { describe, expect, test } from "bun:test";

import maxProfit from "../bestTimeToBuyAndSellStockII";

describe("best time to buy and sell stock ii", () => {
	test("test 1", () => {
		const prices = [7, 1, 5, 3, 6, 4];
		expect(maxProfit(prices)).toBe(7);
	});

	test("test 2", () => {
		const prices = [1, 2, 3, 4, 5];
		expect(maxProfit(prices)).toBe(4);
	});

	test("test 3", () => {
		const prices = [7, 6, 4, 3, 1];
		expect(maxProfit(prices)).toBe(0);
	});
});
