import { describe, expect, test } from "bun:test";

import findWords from "../wordSearchII";

describe("word search ii", () => {
	test("test 1", () => {
		const board = [
			["o", "a", "a", "n"],
			["e", "t", "a", "e"],
			["i", "h", "k", "r"],
			["i", "f", "l", "v"],
		];
		const words = ["oath", "pea", "eat", "rain"];
		const output = new Set<string>(["oath", "eat"]);
		const res = findWords(board, words);
		expect(res.length).toBe(output.size);
		for (const r of res) {
			expect(output.has(r)).toBeTrue();
		}
	});

	test("test 2", () => {
		const board = [
			["a", "b"],
			["c", "d"],
		];
		const words = ["abcd"];
		const output: string[] = [];
		expect(findWords(board, words)).toEqual(output);
	});
});
