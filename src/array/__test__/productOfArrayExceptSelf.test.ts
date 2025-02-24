import { describe, expect, test } from "bun:test";

import productExceptSelf from "../productOfArrayExceptSelf";

describe("product of array except self", () => {
	test("test 1", () => {
		const nums = [1, 2, 3, 4];
		expect(productExceptSelf(nums)).toEqual([24, 12, 8, 6]);
	});

	test("test 2", () => {
		const nums = [-1, 1, 0, -3, 3];
		expect(productExceptSelf(nums)).toEqual([-0, 0, 9, -0, 0]);
	});
});
