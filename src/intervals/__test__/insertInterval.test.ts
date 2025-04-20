import { describe, expect, test } from "bun:test";

import insert from "../insertInterval";

describe("insert interval", () => {
	test("test 1", () => {
		const intervals = [
			[1, 3],
			[6, 9],
		];
		const newInterval = [2, 5];
		const output = [
			[1, 5],
			[6, 9],
		];
		expect(insert(intervals, newInterval)).toEqual(output);
	});

	test("test 2", () => {
		const intervals = [
			[1, 2],
			[3, 5],
			[6, 7],
			[8, 10],
			[12, 16],
		];
		const newInterval = [4, 8];
		const output = [
			[1, 2],
			[3, 10],
			[12, 16],
		];
		expect(insert(intervals, newInterval)).toEqual(output);
	});
});
