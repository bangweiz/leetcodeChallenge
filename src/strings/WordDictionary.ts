class Node {
	public children: Map<string, Node>;
	public isEnd: boolean;

	public constructor() {
		this.children = new Map();
		this.isEnd = false;
	}
}

class WordDictionary {
	private root: Node;

	constructor() {
		this.root = new Node();
	}

	addWord(word: string): void {
		let node = this.root;
		for (const c of word) {
			if (!node.children.has(c)) {
				node.children.set(c, new Node());
			}
			node = node.children.get(c)!;
		}
		node.isEnd = true;
	}

	search(word: string): boolean {
		return this.searchWord(word, 0, this.root);
	}

	private searchWord(word: string, i: number, node: Node): boolean {
		if (i === word.length) {
			return node.isEnd;
		}
		const c = word[i];
		if (c === ".") {
			for (const [_, next] of node.children) {
				if (this.searchWord(word, i + 1, next)) {
					return true;
				}
			}
		} else {
			if (!node.children.has(c)) {
				return false;
			}
			return this.searchWord(word, i + 1, node.children.get(c)!);
		}
		return false;
	}
}
