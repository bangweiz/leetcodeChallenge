import { describe, expect, test } from "bun:test";

import evalRPN from "../evaluateReversePolishNotation";

describe("evaluate reverse polish notation", () => {
	test("test 1", () => {
		const tokens = ["2", "1", "+", "3", "*"];
		expect(evalRPN(tokens)).toBe(9);
	});

	test("test 2", () => {
		const tokens = ["4", "13", "5", "/", "+"];
		expect(evalRPN(tokens)).toBe(6);
	});

	test("test 3", () => {
		const tokens = [
			"10",
			"6",
			"9",
			"3",
			"+",
			"-11",
			"*",
			"/",
			"*",
			"17",
			"+",
			"5",
			"+",
		];
		expect(evalRPN(tokens)).toBe(22);
	});
});
