import { describe, expect, test } from "bun:test";

import calculate from "../basicCalculator";

describe("basic calculator", () => {
	test("test 1", () => {
		const s = "1 + 1";
		expect(calculate(s)).toBe(2);
	});

	test("test 2", () => {
		const s = " 2-1 + 2 ";
		expect(calculate(s)).toBe(3);
	});

	test("test 3", () => {
		const s = "(1+(4+5+2)-3)+(6+8)";
		expect(calculate(s)).toBe(23);
	});

	test("test 4", () => {
		const s = "4 - (1 + 2)";
		expect(calculate(s)).toBe(1);
	});

	test("test 5", () => {
		const s = "4 - (1 - 2)";
		expect(calculate(s)).toBe(5);
	});

	test("test 6", () => {
		const s = "-4";
		expect(calculate(s)).toBe(-4);
	});

	test("test 7", () => {
		const s = "-4 - (-2)";
		expect(calculate(s)).toBe(-2);
	});

	test("test 8", () => {
		const s = "- (3 + (4 + 5))";
		expect(calculate(s)).toBe(-12);
	});
});
