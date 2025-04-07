import { describe, expect, test } from "bun:test";

import minSubArrayLen from "../minimumSizeSubarraySum";

describe("minimum size subarray sum", () => {
	test("test 1", () => {
		const target = 7;
		const nums = [2, 3, 1, 2, 4, 3];
		expect(minSubArrayLen(target, nums)).toBe(2);
	});

	test("test 2", () => {
		const target = 4;
		const nums = [1, 4, 4];
		expect(minSubArrayLen(target, nums)).toBe(1);
	});

	test("test 3", () => {
		const target = 11;
		const nums = [1, 1, 1, 1, 1, 1, 1, 1];
		expect(minSubArrayLen(target, nums)).toBe(0);
	});
});
