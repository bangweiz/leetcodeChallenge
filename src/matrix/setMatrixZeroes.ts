function setZeroes(matrix: number[][]): void {
	const rows = new Set<number>();
	const cols = new Set<number>();
	for (let i = 0; i < matrix.length; i++) {
		for (let j = 0; j < matrix[0].length; j++) {
			if (matrix[i][j] === 0) {
				rows.add(i);
				cols.add(j);
			}
		}
	}

	for (const row of rows) {
		matrix[row].fill(0);
	}
	for (const col of cols) {
		for (const row of matrix) {
			row[col] = 0;
		}
	}
}

export default setZeroes;
