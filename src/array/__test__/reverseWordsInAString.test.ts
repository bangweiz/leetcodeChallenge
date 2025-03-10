import { describe, expect, test } from "bun:test";

import reverseWords from "../reverseWordsInAString";

describe("reverse words in a string", () => {
	test("test 1", () => {
		const s = "the sky is blue";
		expect(reverseWords(s)).toEqual("blue is sky the");
	});

	test("test 2", () => {
		const s = "  hello world  ";
		expect(reverseWords(s)).toEqual("world hello");
	});

	test("test 3", () => {
		const s = "a good   example";
		expect(reverseWords(s)).toEqual("example good a");
	});
});
