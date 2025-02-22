class Node<T> {
	public value: T;
	public next: Node<T> | null = null;
	public prev: Node<T> | null = null;

	constructor(value: T) {
		this.value = value;
	}
}

class LinkedList<T> {
	private head: Node<T> | null = null;
	private tail: Node<T> | null = null;
	private length = 0;

	public append(value: T) {
		const node = new Node(value);
		if (!this.tail) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;
		}
		this.length++;
	}

	public prepend(value: T) {
		const node = new Node(value);
		if (!this.head) {
			this.head = node;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}
		this.length++;
	}

	public peekFront() {
		if (!this.head) {
			return null;
		}
		return this.head.value;
	}

	public peekBack() {
		if (!this.tail) {
			return null;
		}
		return this.tail.value;
	}

	public popFront() {
		if (!this.head) {
			return null;
		}
		const node = this.head;
		if (!this.head.next) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		this.length--;
		return node.value;
	}

	public popBack() {
		if (!this.tail) {
			return null;
		}
		const node = this.tail;
		if (!this.tail.prev) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		this.length--;
		return node.value;
	}

	public get size() {
		return this.length;
	}

	public isEmpty() {
		return this.length === 0;
	}

	public toString() {
		const list: T[] = [];
		let current = this.head;
		while (current) {
			list.push(current.value);
			current = current.next;
		}
		return `[${list.join(", ")}]`;
	}
}

export default LinkedList;
