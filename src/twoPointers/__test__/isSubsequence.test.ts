import { describe, expect, test } from "bun:test";

import isSubsequence from "../isSubsequence";

describe("is subsequence", () => {
	test("test 1", () => {
		const s = "abc";
		const t = "ahbgdc";
		expect(isSubsequence(s, t)).toBeTrue();
	});

	test("test 2", () => {
		const s = "axc";
		const t = "ahbgdc";
		expect(isSubsequence(s, t)).toBeFalse();
	});
});
