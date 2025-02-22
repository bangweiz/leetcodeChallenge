import { describe, expect, test } from "bun:test";

import Queue from "../Queue";

describe("Queue", () => {
	test("add values", () => {
		const q = new Queue<number>();
		q.append(1);
		q.append(2);
		q.append(3);
		q.prepend(4);
		q.prepend(5);
		q.prepend(6);
		expect(q.toString()).toEqual("[6, 5, 4, 1, 2, 3]");
		expect(q.size).toBe(6);
		expect(q.peekBack()).toEqual(3);
		expect(q.peekFront()).toEqual(6);
	});

	test("remove values", () => {
		const q = new Queue<number>();
        expect(q.size).toBe(0);
		expect(q.popFront()).toBeNull();
		expect(q.popBack()).toBeNull();
		expect(q.peekBack()).toBeNull();
		expect(q.peekFront()).toBeNull();

		q.append(1);
		q.append(2);
		q.append(3);
		q.prepend(4);
		q.prepend(5);
		q.prepend(6);

		expect(q.popBack()).toBe(3);
		expect(q.popFront()).toBe(6);
	});
});
