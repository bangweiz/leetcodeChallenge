import { describe, expect, test } from "bun:test";

import convert from "./zigzagConversion";

describe("zigzag conversion", () => {
	test("test 1", () => {
		const s = "PAYPALISHIRING";
		expect(convert(s, 3)).toEqual("PAHNAPLSIIGYIR");
	});

	test("test 2", () => {
		const s = "PAYPALISHIRING";
		expect(convert(s, 4)).toEqual("PINALSIGYAHRPI");
	});

	test("test 3", () => {
		const s = "A";
		expect(convert(s, 1)).toEqual("A");
	});

	test("test 4", () => {
		const s = "ABCDEF";
		expect(convert(s, 2)).toEqual("ACEBDF");
	});
});
