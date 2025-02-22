import { describe, expect, test } from "bun:test";

import removeElement from "../removeElement";

describe("remove element", () => {
	test("test 1", () => {
		const nums = [3, 2, 2, 3];
		const val = 3;
		const res = removeElement(nums, val);
		expect(res).toBe(2);
		expect(nums).toEqual([2, 2, 3, 3]);
	});

	test("test 2", () => {
		const nums = [0, 1, 2, 2, 3, 0, 4, 2];
		const val = 2;
		const res = removeElement(nums, val);
		expect(res).toBe(5);
		expect(nums).toEqual([0, 1, 3, 0, 4, 2, 2, 2]);
	});
});
