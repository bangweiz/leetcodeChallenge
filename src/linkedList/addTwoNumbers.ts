import ListNode from "./ListNode";

function addTwoNumbers(
	l1: ListNode | null,
	l2: ListNode | null,
): ListNode | null {
	return add(l1, l2, 0);
}

function add(
	l1: ListNode | null,
	l2: ListNode | null,
	carry: number,
): ListNode | null {
	if (!l1 && !l2) {
		if (carry > 0) {
			return new ListNode(carry);
		}
		return null;
	}
	if (!l1) {
		const res = l2!.val + carry;
		const [newCarry, remainder] = cal(res);
		return new ListNode(remainder, add(null, l2!.next, newCarry));
	}
	if (!l2) {
		const res = l1!.val + carry;
		const [newCarry, remainder] = cal(res);
		return new ListNode(remainder, add(l1!.next, null, newCarry));
	}
	const res = l1.val + l2.val + carry;
	const [newCarry, remainder] = cal(res);
	return new ListNode(remainder, add(l1.next, l2.next, newCarry));
}

function cal(num: number): [number, number] {
	return [Math.floor(num / 10), num % 10];
}
