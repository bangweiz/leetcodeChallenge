import { describe, expect, test } from "bun:test";

import longestConsecutive from "../longestConsecutiveSequence";

describe("longest consecutive sequence", () => {
	test("test 1", () => {
		const nums = [100, 4, 200, 1, 3, 2];
		expect(longestConsecutive(nums)).toBe(4);
	});

	test("test 2", () => {
		const nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1];
		expect(longestConsecutive(nums)).toBe(9);
	});

	test("test 3", () => {
		const nums = [1, 0, 1, 2];
		expect(longestConsecutive(nums)).toBe(3);
	});
});
