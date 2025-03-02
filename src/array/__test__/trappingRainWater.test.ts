import { describe, expect, test } from "bun:test";

import trap from "../trappingRainWater";

describe("trapping tain water", () => {
	test("test 1", () => {
		const height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1];
		expect(trap(height)).toBe(6);
	});

	test("test 2", () => {
		const height = [4, 2, 0, 3, 2, 5];
		expect(trap(height)).toBe(9);
	});

	test("test 3", () => {
		const height = [5, 5, 1, 7, 1, 1, 5, 2, 7, 6];
		expect(trap(height)).toBe(23);
	});
});
