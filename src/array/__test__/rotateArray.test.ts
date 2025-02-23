import { describe, expect, test } from "bun:test";

import rotate from "../rotateArray";

describe("rotate array", () => {
	test("test 1", () => {
		const nums = [1, 2, 3, 4, 5, 6, 7];
		const k = 3;
		rotate(nums, k);
		expect(nums).toEqual([5, 6, 7, 1, 2, 3, 4]);
	});

	test("test 2", () => {
		const nums = [-1, -100, 3, 99];
		const k = 2;
		rotate(nums, k);
		expect(nums).toEqual([3, 99, -1, -100]);
	});

	test("test 3", () => {
		const nums = [1, 2, 3, 4];
		const k = 7;
		rotate(nums, k);
		expect(nums).toEqual([2, 3, 4, 1]);
	});
});
