function isValidSudoku(board: string[][]): boolean {
	const row: number[] = new Array(9).fill(0);
	const col: number[] = new Array(9).fill(0);
	const box: number[] = new Array(9).fill(0);
	for (let i = 0; i < 9; i++) {
		for (let j = 0; j < 9; j++) {
			const rowNum = board[i][j];
			if (rowNum !== ".") {
				row[Number.parseInt(rowNum) - 1]++;
			}
			const colNum = board[j][i];
			if (colNum !== ".") {
				col[Number.parseInt(colNum) - 1]++;
			}
			const boxNum =
				board[3 * Math.floor(i / 3) + Math.floor(j / 3)][3 * (i % 3) + (j % 3)];
			if (boxNum !== ".") {
				box[Number.parseInt(boxNum) - 1]++;
			}
		}
		if (!valid()) {
			return false;
		}
		row.fill(0);
		col.fill(0);
		box.fill(0);
	}

	return true;

	function valid() {
		return (
			row.every((count) => count <= 1) &&
			col.every((count) => count <= 1) &&
			box.every((count) => count <= 1)
		);
	}
}

export default isValidSudoku;
