import { describe, expect, test } from "bun:test";

import gameOfLife from "../gameOfLife";

describe("set matrix zeroes", () => {
	test("test 1", () => {
		const matrix = [
			[0, 1, 0],
			[0, 0, 1],
			[1, 1, 1],
			[0, 0, 0],
		];
		const output = [
			[0, 0, 0],
			[1, 0, 1],
			[0, 1, 1],
			[0, 1, 0],
		];
		gameOfLife(matrix);
		expect(matrix).toEqual(output);
	});

	test("test 2", () => {
		const matrix = [
			[1, 1],
			[1, 0],
		];
		const output = [
			[1, 1],
			[1, 1],
		];
		gameOfLife(matrix);
		expect(matrix).toEqual(output);
	});
});
