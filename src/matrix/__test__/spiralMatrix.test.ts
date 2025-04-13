import { describe, expect, test } from "bun:test";

import spiralOrder from "../spiralMatrix";

describe("valid sudoku", () => {
	test("test 1", () => {
		const matrix = [
			[1, 2, 3],
			[4, 5, 6],
			[7, 8, 9],
		];
		const output = [1, 2, 3, 6, 9, 8, 7, 4, 5];
		expect(spiralOrder(matrix)).toEqual(output);
	});

	test("test 2", () => {
		const matrix = [
			[1, 2, 3, 4],
			[5, 6, 7, 8],
			[9, 10, 11, 12],
		];
		const output = [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7];
		expect(spiralOrder(matrix)).toEqual(output);
	});
});
