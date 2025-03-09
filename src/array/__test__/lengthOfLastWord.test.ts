import { describe, expect, test } from "bun:test";

import lengthOfLastWord from "../lengthOfLastWord";

describe("length of last word", () => {
	test("test 1", () => {
		expect(lengthOfLastWord("Hello World")).toBe(5);
	});

	test("test 2", () => {
		expect(lengthOfLastWord("   fly me   to   the moon  ")).toBe(4);
	});

	test("test 3", () => {
		expect(lengthOfLastWord("luffy is still joyboy")).toBe(6);
	});
});
