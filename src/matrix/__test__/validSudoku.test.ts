import { describe, expect, test } from "bun:test";

import isValidSudoku from "../validSudoku";

describe("valid sudoku", () => {
	test("test 1", () => {
		const board = [
			["5", "3", ".", ".", "7", ".", ".", ".", "."],
			["6", ".", ".", "1", "9", "5", ".", ".", "."],
			[".", "9", "8", ".", ".", ".", ".", "6", "."],
			["8", ".", ".", ".", "6", ".", ".", ".", "3"],
			["4", ".", ".", "8", ".", "3", ".", ".", "1"],
			["7", ".", ".", ".", "2", ".", ".", ".", "6"],
			[".", "6", ".", ".", ".", ".", "2", "8", "."],
			[".", ".", ".", "4", "1", "9", ".", ".", "5"],
			[".", ".", ".", ".", "8", ".", ".", "7", "9"],
		];
		expect(isValidSudoku(board)).toBeTrue();
	});

	test("test 2", () => {
		const board = [
			["8", "3", ".", ".", "7", ".", ".", ".", "."],
			["6", ".", ".", "1", "9", "5", ".", ".", "."],
			[".", "9", "8", ".", ".", ".", ".", "6", "."],
			["8", ".", ".", ".", "6", ".", ".", ".", "3"],
			["4", ".", ".", "8", ".", "3", ".", ".", "1"],
			["7", ".", ".", ".", "2", ".", ".", ".", "6"],
			[".", "6", ".", ".", ".", ".", "2", "8", "."],
			[".", ".", ".", "4", "1", "9", ".", ".", "5"],
			[".", ".", ".", ".", "8", ".", ".", "7", "9"],
		];
		expect(isValidSudoku(board)).toBeFalse();
	});

	test("test 3", () => {
		const board = [
			[".", ".", ".", ".", "5", ".", ".", "1", "."],
			[".", "4", ".", "3", ".", ".", ".", ".", "."],
			[".", ".", ".", ".", ".", "3", ".", ".", "1"],
			["8", ".", ".", ".", ".", ".", ".", "2", "."],
			[".", ".", "2", ".", "7", ".", ".", ".", "."],
			[".", "1", "5", ".", ".", ".", ".", ".", "."],
			[".", ".", ".", ".", ".", "2", ".", ".", "."],
			[".", "2", ".", "9", ".", ".", ".", ".", "."],
			[".", ".", "4", ".", ".", ".", ".", ".", "."],
		];
		expect(isValidSudoku(board)).toBeFalse();
	});
});
