import { describe, expect, test } from "bun:test";

import hIndex from "../hIndex";

describe("H index", () => {
	test("test 1", () => {
		const citations = [3, 0, 6, 1, 5];
		expect(hIndex(citations)).toBe(3);
	});

	test("test 2", () => {
		const citations = [1, 3, 1];
		expect(hIndex(citations)).toBe(1);
	});

	test("test 3", () => {
		const citations = [1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3];
		expect(hIndex(citations)).toBe(6);
	});
});
