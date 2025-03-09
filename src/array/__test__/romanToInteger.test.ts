import { describe, expect, test } from "bun:test";

import romanToInt from "../romanToInteger";

describe("romain to integer", () => {
	test("test 1", () => {
		expect(romanToInt("III")).toBe(3);
	});

	test("test 2", () => {
		expect(romanToInt("LVIII")).toBe(58);
	});

	test("test 3", () => {
		expect(romanToInt("MCMXCIV")).toBe(1994);
	});
});
