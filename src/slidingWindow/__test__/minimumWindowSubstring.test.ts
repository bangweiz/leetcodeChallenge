import { describe, expect, test } from "bun:test";

import minWindow from "../minimumWindowSubstring";

describe("minimum size subarray sum", () => {
	test("test 1", () => {
		const s = "ADOBECODEBANC";
		const t = "ABC";
		expect(minWindow(s, t)).toBe("BANC");
	});

	test("test 2", () => {
		const s = "a";
		const t = "a";
		expect(minWindow(s, t)).toBe("a");
	});

	test("test 3", () => {
		const s = "a";
		const t = "aa";
		expect(minWindow(s, t)).toBe("");
	});
});
