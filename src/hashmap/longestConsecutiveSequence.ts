enum Direction {
	Both = 0,
	Left = 1,
	Right = 2,
}

function longestConsecutive(nums: number[]): number {
	const map = new Map<number, number>();
	for (const num of nums) {
		map.set(num, (map.get(num) || 0) + 1);
	}

	let res = 0;
	for (const num of nums) {
		res = Math.max(res, recursiveRemove(num));
	}

	return res;

	function recursiveRemove(num: number, direction = Direction.Both): number {
		const removedNum = removeNum(num);
		if (!removedNum) {
			return 0;
		}
		switch (direction) {
			case Direction.Both:
				return (
					recursiveRemove(num - 1, Direction.Left) +
					recursiveRemove(num + 1, Direction.Right) +
					1
				);
			case Direction.Left:
				return recursiveRemove(num - 1, Direction.Left) + 1;
			case Direction.Right:
				return recursiveRemove(num + 1, Direction.Right) + 1;
		}
	}

	function removeNum(num: number): boolean {
		const count = map.get(num);
		if (!count) {
			return false;
		}
		if (count === 1) {
			map.delete(num);
		} else {
			map.set(num, count - 1);
		}
		return true;
	}
}

export default longestConsecutive;
