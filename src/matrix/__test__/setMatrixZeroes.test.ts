import { describe, expect, test } from "bun:test";

import setZeroes from "../setMatrixZeroes";

describe("set matrix zeroes", () => {
	test("test 1", () => {
		const matrix = [
			[1, 1, 1],
			[1, 0, 1],
			[1, 1, 1],
		];
		const output = [
			[1, 0, 1],
			[0, 0, 0],
			[1, 0, 1],
		];
		setZeroes(matrix);
		expect(matrix).toEqual(output);
	});

	test("test 2", () => {
		const matrix = [
			[0, 1, 2, 0],
			[3, 4, 5, 2],
			[1, 3, 1, 5],
		];
		const output = [
			[0, 0, 0, 0],
			[0, 4, 5, 0],
			[0, 3, 1, 0],
		];
		setZeroes(matrix);
		expect(matrix).toEqual(output);
	});
});
