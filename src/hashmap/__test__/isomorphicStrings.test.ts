import { describe, expect, test } from "bun:test";

import isIsomorphic from "../isomorphicStrings";

describe("isomorphic strings", () => {
	test("test 1", () => {
		expect(isIsomorphic("egg", "add")).toBeTrue();
	});

	test("test 2", () => {
		expect(isIsomorphic("foo", "bar")).toBeFalse();
	});

	test("test 3", () => {
		expect(isIsomorphic("paper", "title")).toBeTrue();
	});

	test("test 4", () => {
		expect(isIsomorphic("badc", "baba")).toBeFalse();
	});
});
