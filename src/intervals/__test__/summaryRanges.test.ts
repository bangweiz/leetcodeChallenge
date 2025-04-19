import { describe, expect, test } from "bun:test";

import summaryRanges from "../summaryRanges";

describe("summary ranges", () => {
	test("test 1", () => {
		const nums = [0, 1, 2, 4, 5, 7];
		const output = ["0->2", "4->5", "7"];
		expect(summaryRanges(nums)).toEqual(output);
	});

	test("test 2", () => {
		const nums = [0, 2, 3, 4, 6, 8, 9];
		const output = ["0", "2->4", "6", "8->9"];
		expect(summaryRanges(nums)).toEqual(output);
	});
});
