import { describe, expect, test } from "bun:test";

import strStr from "../findTheIndexOfTheFirstOccurrenceInAString";

describe("find the index of the first occurrence in a string", () => {
	test("test 1", () => {
		const haystack = "sadbutsad";
		const needle = "sad";
		expect(strStr(haystack, needle)).toBe(0);
	});

	test("test 1", () => {
		const haystack = "leetcode";
		const needle = "leeto";
		expect(strStr(haystack, needle)).toBe(-1);
	});
});
