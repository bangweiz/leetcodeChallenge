function gameOfLife(board: number[][]): void {
	const locations: number[][] = [];
	for (let i = 0; i < board.length; i++) {
		for (let j = 0; j < board[i].length; j++) {
			if (needFlip(i, j)) {
				locations.push([i, j]);
			}
		}
	}

	for (const [i, j] of locations) {
		board[i][j] ^= 1;
	}

	function needFlip(i: number, j: number): boolean {
		const neighbors = [
			[i - 1, j - 1],
			[i - 1, j],
			[i - 1, j + 1],
			[i, j - 1],
			[i, j + 1],
			[i + 1, j - 1],
			[i + 1, j],
			[i + 1, j + 1],
		];
		let countOne = 0;
		for (const [x, y] of neighbors) {
			if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
				continue;
			}
			if (board[x][y] === 1) {
				countOne++;
			}
		}
		if (board[i][j] === 0) {
			return countOne === 3;
		}
		return countOne !== 2 && countOne !== 3;
	}
}

export default gameOfLife;
