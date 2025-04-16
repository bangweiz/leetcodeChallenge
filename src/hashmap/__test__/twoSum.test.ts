import { describe, expect, test } from "bun:test";

import twoSum from "../twoSum";

describe("two sum", () => {
	test("test 1", () => {
		const nums = [2, 7, 11, 15];
		const target = 9;
		const output = [0, 1];
		expect(twoSum(nums, target)).toEqual(output);
	});

	test("test 2", () => {
		const nums = [3, 2, 4];
		const target = 6;
		const output = [1, 2];
		expect(twoSum(nums, target)).toEqual(output);
	});

	test("test 2", () => {
		const nums = [3, 3];
		const target = 6;
		const output = [0, 1];
		expect(twoSum(nums, target)).toEqual(output);
	});
});
