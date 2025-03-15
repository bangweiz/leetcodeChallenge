import { describe, expect, test } from "bun:test";

import isPalindrome from "../validPalindrome";

describe("valid palindrome", () => {
	test("test 1", () => {
		const s = "A man, a plan, a canal: Panama";
		expect(isPalindrome(s)).toBeTrue();
	});

	test("test 2", () => {
		const s = "race a car";
		expect(isPalindrome(s)).toBeFalse();
	});

	test("test 3", () => {
		const s = " ";
		expect(isPalindrome(s)).toBeTrue();
	});
});
