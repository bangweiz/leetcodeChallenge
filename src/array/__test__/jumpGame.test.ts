import { describe, expect, test } from "bun:test";

import canJump from "../jumpGame";

describe("jump game", () => {
	test("test 1", () => {
		const nums = [2, 3, 1, 1, 4];
		expect(canJump(nums)).toBeTrue();
	});

	test("test 2", () => {
		const nums = [3, 2, 1, 0, 4];
		expect(canJump(nums)).toBeFalse();
	});
});
