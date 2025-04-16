import { describe, expect, test } from "bun:test";

import isHappy from "../happyNumber";

describe("happy number", () => {
	test("test 1", () => {
		expect(isHappy(19)).toBeTrue();
	});

	test("test 2", () => {
		expect(isHappy(2)).toBeFalse();
	});
});
