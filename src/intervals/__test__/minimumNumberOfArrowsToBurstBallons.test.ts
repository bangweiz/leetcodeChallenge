import { describe, expect, test } from "bun:test";

import findMinArrowShots from "../minimumNumberOfArrowsToBurstBallons";

describe("minimum number of arrows to burst ballons", () => {
	test("test 1", () => {
		const points = [
			[10, 16],
			[2, 8],
			[1, 6],
			[7, 12],
		];
		expect(findMinArrowShots(points)).toBe(2);
	});

	test("test 2", () => {
		const points = [
			[1, 2],
			[3, 4],
			[5, 6],
			[7, 8],
		];
		expect(findMinArrowShots(points)).toBe(4);
	});

	test("test 3", () => {
		const points = [
			[1, 2],
			[2, 3],
			[3, 4],
			[4, 5],
		];
		expect(findMinArrowShots(points)).toBe(2);
	});
});
