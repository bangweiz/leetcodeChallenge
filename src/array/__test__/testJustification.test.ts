import { describe, expect, test } from "bun:test";

import fullJustify from "../testJustification";

describe("test justification", () => {
	test("test 1", () => {
		const words = [
			"This",
			"is",
			"an",
			"example",
			"of",
			"text",
			"justification.",
		];
		const res = ["This    is    an", "example  of text", "justification.  "];
		expect(fullJustify(words, 16)).toEqual(res);
	});

	test("test 2", () => {
		const words = ["What", "must", "be", "acknowledgment", "shall", "be"];
		const res = ["What   must   be", "acknowledgment  ", "shall be        "];
		expect(fullJustify(words, 16)).toEqual(res);
	});
});
