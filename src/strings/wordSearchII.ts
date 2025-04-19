class Node {
	public children: Map<string, Node>;
	public isEnd: boolean;

	public constructor() {
		this.children = new Map();
		this.isEnd = false;
	}
}

class Trie {
	public root: Node;

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
}

function findWords(board: string[][], words: string[]): string[] {
	const trie = new Trie();
	for (const word of words) {
		trie.insert(word);
	}

	const res = new Set<string>();
	for (let i = 0; i < board.length; i++) {
		for (let j = 0; j < board[i].length; j++) {
			const visited: boolean[][] = [];
			for (let k = 0; k < board.length; k++) {
				visited.push(new Array(board[k].length).fill(false));
			}
			findWord(i, j, [], visited, trie.root);
		}
	}

	return Array.from(res);

	function findWord(
		i: number,
		j: number,
		word: string[],
		visited: boolean[][],
		node: Node,
	) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
			return;
		}
		if (visited[i][j]) {
			return;
		}
		const next = node.children.get(board[i][j]);
		if (!next) {
			return;
		}

		visited[i][j] = true;
		word.push(board[i][j]);
		if (next.isEnd) {
			res.add(word.join(""));
		}
		findWord(i + 1, j, word, visited, next);
		findWord(i - 1, j, word, visited, next);
		findWord(i, j + 1, word, visited, next);
		findWord(i, j - 1, word, visited, next);
		visited[i][j] = false;
		word.pop();
	}
}

export default findWords;
