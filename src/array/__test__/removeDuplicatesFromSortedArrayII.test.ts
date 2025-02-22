import { describe, expect, test } from "bun:test";

import removeDuplicates from "../removeDuplicatesFromSortedArrayII";

describe("remove duplicates ii", () => {
	test("test 1", () => {
		const nums = [1, 1, 1, 2, 2, 3];
		const res = removeDuplicates(nums);
		const expectedRes = [1, 1, 2, 2, 3];
		expect(res).toBe(5);
		for (let i = 0; i < res; i++) {
			expect(nums[i]).toBe(expectedRes[i]);
		}
	});

	test("test 2", () => {
		const nums = [0, 0, 1, 1, 1, 1, 2, 3, 3];
		const res = removeDuplicates(nums);
		const expectedRes = [0, 0, 1, 1, 2, 3, 3];
		expect(res).toBe(7);
		for (let i = 0; i < res; i++) {
			expect(nums[i]).toBe(expectedRes[i]);
		}
	});
});
