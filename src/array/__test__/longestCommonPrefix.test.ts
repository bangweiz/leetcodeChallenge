import { describe, expect, test } from "bun:test";

import longestCommonPrefix from "../longestCommonPrefix";

describe("longest common prefix", () => {
	test("test 1", () => {
		const strs = ["flower", "flow", "flight"];
		expect(longestCommonPrefix(strs)).toEqual("fl");
	});

	test("test 2", () => {
		const strs = ["dog", "racecar", "car"];
		expect(longestCommonPrefix(strs)).toEqual("");
	});
});
