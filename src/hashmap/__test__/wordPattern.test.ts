import { describe, expect, test } from "bun:test";

import wordPattern from "../wordPattern";

describe("word pattern", () => {
	test("test 1", () => {
		const pattern = "abba";
		const s = "dog cat cat dog";
		expect(wordPattern(pattern, s)).toBeTrue();
	});

	test("test 2", () => {
		const pattern = "abba";
		const s = "dog cat cat fish";
		expect(wordPattern(pattern, s)).toBeFalse();
	});

	test("test 3", () => {
		const pattern = "aaaa";
		const s = "dog cat cat dog";
		expect(wordPattern(pattern, s)).toBeFalse();
	});
});
