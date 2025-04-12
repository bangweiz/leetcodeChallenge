import { describe, expect, test } from "bun:test";

import findSubstring from "../substringWithConcatenationOfAllWorlds";

describe("minimum size subarray sum", () => {
	test("test 1", () => {
		const s = "barfoothefoobarman";
		const words = ["foo", "bar"];
		const output = [0, 9];
		expect(findSubstring(s, words)).toEqual(output);
	});

	test("test 2", () => {
		const s = "wordgoodgoodgoodbestword";
		const words = ["word", "good", "best", "word"];
		const output: number[] = [];
		expect(findSubstring(s, words)).toEqual(output);
	});

	test("test 3", () => {
		const s = "barfoofoobarthefoobarman";
		const words = ["bar", "foo", "the"];
		const output = [6, 9, 12];
		expect(findSubstring(s, words)).toEqual(output);
	});

	test("test 4", () => {
		const s = "a";
		const words = ["a", "a"];
		const output: number[] = [];
		expect(findSubstring(s, words)).toEqual(output);
	});
});
