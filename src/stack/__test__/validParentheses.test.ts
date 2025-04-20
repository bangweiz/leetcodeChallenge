import { describe, expect, test } from "bun:test";

import isValid from "../validParentheses";

describe("valid parentheses", () => {
	test("test 1", () => {
		const s = "()";
		expect(isValid(s)).toBeTrue();
	});

	test("test 2", () => {
		const s = "()[]{}";
		expect(isValid(s)).toBeTrue();
	});

	test("test 3", () => {
		const s = "(]";
		expect(isValid(s)).toBeFalse();
	});

	test("test 4", () => {
		const s = "([])";
		expect(isValid(s)).toBeTrue();
	});
});
