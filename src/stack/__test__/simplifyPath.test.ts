import { describe, expect, test } from "bun:test";

import simplifyPath from "../simplifyPath";

describe("simplify path", () => {
	test("test 1", () => {
		const path = "/home/";
		const output = "/home";
		expect(simplifyPath(path)).toEqual(output);
	});

	test("test 2", () => {
		const path = "/home//foo/";
		const output = "/home/foo";
		expect(simplifyPath(path)).toEqual(output);
	});

	test("test 3", () => {
		const path = "/../";
		const output = "/";
		expect(simplifyPath(path)).toEqual(output);
	});

	test("test 4", () => {
		const path = "/.../a/../b/c/../d/./";
		const output = "/.../b/d";
		expect(simplifyPath(path)).toEqual(output);
	});
});
