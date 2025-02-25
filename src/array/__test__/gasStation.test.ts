import { describe, expect, test } from "bun:test";

import canCompleteCircuit from "../gasStation";

describe("gas station", () => {
	test("test 1", () => {
		const gas = [1, 2, 3, 4, 5];
		const cost = [3, 4, 5, 1, 2];
		expect(canCompleteCircuit(gas, cost)).toBe(3);
	});

	test("test 2", () => {
		const gas = [2, 3, 4];
		const cost = [3, 4, 3];
		expect(canCompleteCircuit(gas, cost)).toBe(-1);
	});
});
