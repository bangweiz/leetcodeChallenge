import { describe, expect, test } from "bun:test";

import RandomizedSet from "../RandomizedSet";

describe("RandomizedSet", () => {
	test("test 1", () => {
		const set = new RandomizedSet();

		expect(set.insert(1)).toBeTrue();
		expect(set.remove(2)).toBeFalse();
		expect(set.insert(2)).toBeTrue();
		set.getRandom();
		expect(set.remove(1)).toBeTrue();
		expect(set.insert(2)).toBeFalse();
		expect(set.getRandom()).toBe(2);
	});

	test("test 2", () => {
		const set = new RandomizedSet();

		expect(set.remove(0)).toBeFalse();
		expect(set.remove(0)).toBeFalse();
		expect(set.insert(0)).toBeTrue();
		expect(set.getRandom()).toBe(0);
		expect(set.remove(0)).toBeTrue();
		expect(set.insert(0)).toBeTrue();
	});
});
