import { describe, expect, test } from "bun:test";

import threeSum from "../threeSum";

describe("3 sum", () => {
	test("test 1", () => {
		const nums = [-1, 0, 1, 2, -1, -4];
		const res = [
			[-1, -1, 2],
			[-1, 0, 1],
		];
		expect(threeSum(nums)).toEqual(res);
	});

	test("test 2", () => {
		const nums = [0, 1, 1];
		const res: number[][] = [];
		expect(threeSum(nums)).toEqual(res);
	});

	test("test 3", () => {
		const nums = [0, 0, 0];
		const res = [[0, 0, 0]];
		expect(threeSum(nums)).toEqual(res);
	});
});
