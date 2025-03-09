import { describe, expect, test } from "bun:test";

import intToRoman from "../integerToRoman";

describe("integer to romain", () => {
	test("test 1", () => {
		expect(intToRoman(58)).toEqual("LVIII");
	});

	test("test 2", () => {
		expect(intToRoman(1994)).toEqual("MCMXCIV");
	});

	test("test 3", () => {
		expect(intToRoman(3749)).toEqual("MMMDCCXLIX");
	});
});
