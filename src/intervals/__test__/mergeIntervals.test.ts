import { describe, expect, test } from "bun:test";

import merge from "../mergeIntervals";

describe("merge intervals", () => {
	test("test 1", () => {
		const intervals = [
			[1, 3],
			[2, 6],
			[8, 10],
			[15, 18],
		];
		const output = [
			[1, 6],
			[8, 10],
			[15, 18],
		];
		expect(merge(intervals)).toEqual(output);
	});

	test("test 2", () => {
		const intervals = [
			[1, 4],
			[4, 5],
		];
		const output = [[1, 5]];
		expect(merge(intervals)).toEqual(output);
	});
});
