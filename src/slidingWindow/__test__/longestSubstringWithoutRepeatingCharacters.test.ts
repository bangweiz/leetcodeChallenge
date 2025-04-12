import { describe, expect, test } from "bun:test";

import lengthOfLongestSubstring from "../longestSubstringWithoutRepeatingCharacters";

describe("longest substring without repeating characters", () => {
	test("test 1", () => {
		const s = "abcabcbb";
		expect(lengthOfLongestSubstring(s)).toBe(3);
	});

	test("test 2", () => {
		const s = "bbbbb";
		expect(lengthOfLongestSubstring(s)).toBe(1);
	});

	test("test 3", () => {
		const s = "pwwkew";
		expect(lengthOfLongestSubstring(s)).toBe(3);
	});

	test("test 4", () => {
		const s = "bwf";
		expect(lengthOfLongestSubstring(s)).toBe(3);
	});
});
