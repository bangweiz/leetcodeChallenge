import type ListNode from "./ListNode";

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
