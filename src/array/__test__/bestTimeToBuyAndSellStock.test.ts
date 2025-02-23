import { describe, expect, test } from "bun:test";

import maxProfit from "../bestTimeToBuyAndSellStock";

describe("best time to buy and sell stock", () => {
	test("test 1", () => {
		const prices = [7, 1, 5, 3, 6, 4];
		expect(maxProfit(prices)).toBe(5);
	});

	test("test 2", () => {
		const prices = [7, 6, 4, 3, 1];
		expect(maxProfit(prices)).toBe(0);
	});
});
