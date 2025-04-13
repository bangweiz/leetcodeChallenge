enum Direction {
	Left = 0,
	Right = 1,
	Up = 2,
	Down = 3,
}

function spiralOrder(matrix: number[][]): number[] {
	const visited: boolean[][] = [];
	for (let i = 0; i < matrix.length; i++) {
		visited.push(new Array(matrix[i].length).fill(false));
	}
	const res: number[] = [];

	move(Direction.Right, 0, 0);

	return res;

	function move(prevDirection: Direction, i: number, j: number) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return;
		}
		if (visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		res.push(matrix[i][j]);
		switch (prevDirection) {
			case Direction.Right:
				move(Direction.Right, i, j + 1);
				move(Direction.Down, i + 1, j);
				break;
			case Direction.Down:
				move(Direction.Down, i + 1, j);
				move(Direction.Left, i, j - 1);
				break;
			case Direction.Left:
				move(Direction.Left, i, j - 1);
				move(Direction.Up, i - 1, j);
				break;
			case Direction.Up:
				move(Direction.Up, i - 1, j);
				move(Direction.Right, i, j + 1);
				break;
		}
	}
}

export default spiralOrder;
