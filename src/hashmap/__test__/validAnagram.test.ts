import { describe, expect, test } from "bun:test";

import isAnagram from "../validAnagram";

describe("valid anagram", () => {
	test("test 1", () => {
		const s = "anagram";
		const t = "nagaram";
		expect(isAnagram(s, t)).toBeTrue();
	});

	test("test 2", () => {
		const s = "rat";
		const t = "car";
		expect(isAnagram(s, t)).toBeFalse();
	});
});
