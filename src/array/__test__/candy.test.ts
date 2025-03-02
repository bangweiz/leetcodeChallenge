import { describe, expect, test } from "bun:test";

import candy from "../candy";

describe("candy", () => {
	test("test 1", () => {
		const ratings = [1, 0, 2];
		expect(candy(ratings)).toBe(5);
	});

	test("test 2", () => {
		const ratings = [1, 2, 2];
		expect(candy(ratings)).toBe(4);
	});
});
