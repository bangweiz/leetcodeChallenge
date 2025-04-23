class ListNode {
	val: number;
	next: ListNode | null;
	constructor(val?: number, next?: ListNode | null) {
		this.val = val === undefined ? 0 : val;
		this.next = next === undefined ? null : next;
	}
}

function hasCycle(head: ListNode | null): boolean {
	let fast = head;
	let slow = head;
	while (fast) {
		const nextFast = fast.next;
		if (!nextFast) {
			return false;
		}
		fast = nextFast.next;
		slow = slow!.next;
		if (fast === slow) {
			return true;
		}
	}
	return false;
}
