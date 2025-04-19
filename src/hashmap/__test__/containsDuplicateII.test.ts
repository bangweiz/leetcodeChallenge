import { describe, expect, test } from "bun:test";

import containsNearbyDuplicate from "../containsDuplicateII";

describe("contains duplicate ii", () => {
	test("test 1", () => {
		const nums = [1, 2, 3, 1];
		const k = 3;
		expect(containsNearbyDuplicate(nums, k)).toBeTrue();
	});

	test("test 2", () => {
		const nums = [1, 0, 1, 1];
		const k = 1;
		expect(containsNearbyDuplicate(nums, k)).toBeTrue();
	});

	test("test 3", () => {
		const nums = [1, 2, 3, 1, 2, 3];
		const k = 2;
		expect(containsNearbyDuplicate(nums, k)).toBeFalse();
	});
});
