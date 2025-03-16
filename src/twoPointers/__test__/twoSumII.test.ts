import { describe, expect, test } from "bun:test";

import twoSum from "../twoSumII";

describe("two sum II - input array is sorted", () => {
	test("test 1", () => {
		const numbers = [2, 7, 11, 15];
		const target = 9;
		expect(twoSum(numbers, target)).toEqual([1, 2]);
	});

	test("test 2", () => {
		const numbers = [2, 3, 4];
		const target = 6;
		expect(twoSum(numbers, target)).toEqual([1, 3]);
	});

	test("test 3", () => {
		const numbers = [-1, 0];
		const target = -1;
		expect(twoSum(numbers, target)).toEqual([1, 2]);
	});
});
