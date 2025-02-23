import { describe, expect, test } from "bun:test";

import jump from "../jumpGameII";

describe("jump game ii", () => {
	test("test 1", () => {
		const nums = [2, 3, 1, 1, 4];
		expect(jump(nums)).toBe(2);
	});

	test("test 2", () => {
		const nums = [2, 3, 0, 1, 4];
		expect(jump(nums)).toBe(2);
	});

	test("test 3", () => {
		const nums = [1, 2, 1, 1, 1];
		expect(jump(nums)).toBe(3);
	});
});
