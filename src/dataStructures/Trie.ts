class Node {
	public children: Map<string, Node>;
	public isEnd: boolean;

	public constructor() {
		this.children = new Map();
		this.isEnd = false;
	}
}

class Trie {
	private root: Node;

	public constructor() {
		this.root = new Node();
	}

	public insert(word: string) {
		let node = this.root;
		for (const c of word) {
			if (!node.children.has(c)) {
				node.children.set(c, new Node());
			}
			node = node.children.get(c)!;
		}
		node.isEnd = true;
	}

	public search(word: string): boolean {
		let node = this.root;
		for (const c of word) {
			if (!node.children.has(c)) {
				return false;
			}
			node = node.children.get(c)!;
		}
		return node.isEnd;
	}

	public startsWith(prefix: string): boolean {
		let node = this.root;
		for (const c of prefix) {
			if (!node.children.has(c)) {
				return false;
			}
			node = node.children.get(c)!;
		}
		return true;
	}
}

export default Trie;
