import { describe, expect, test } from "bun:test";

import maxArea from "../containerWithMostWater";

describe("container with most water", () => {
	test("test 1", () => {
		const height = [1, 8, 6, 2, 5, 4, 8, 3, 7];
		expect(maxArea(height)).toBe(49);
	});

	test("test 2", () => {
		const height = [1, 1];
		expect(maxArea(height)).toBe(1);
	});
});
