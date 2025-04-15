import { describe, expect, test } from "bun:test";

import canConstruct from "../ransomNote";

describe("ransom note", () => {
	test("test 1", () => {
		expect(canConstruct("a", "b")).toBeFalse();
	});

	test("test 2", () => {
		expect(canConstruct("aa", "ab")).toBeFalse();
	});

	test("test 3", () => {
		expect(canConstruct("aa", "aab")).toBeTrue();
	});
});
