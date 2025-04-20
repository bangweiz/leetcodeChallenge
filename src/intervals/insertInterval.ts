function insert(intervals: number[][], newInterval: number[]): number[][] {
	if (intervals.length === 0) {
		return [newInterval];
	}

	const res: number[][] = [];
	let breakPoint = -1;
	for (let i = 0; i < intervals.length; i++) {
		const [start, end] = intervals[i];
		if (end < newInterval[0]) {
			res.push([start, end]);
		} else {
			res.push([...newInterval]);
			breakPoint = i;
			break;
		}
	}

	if (breakPoint === -1) {
		res.push([...newInterval]);
		return res;
	}
	for (let i = breakPoint; i < intervals.length; i++) {
		const [start, end] = intervals[i];
		if (start <= res[res.length - 1][1]) {
			res[res.length - 1][0] = Math.min(res[res.length - 1][0], start);
			res[res.length - 1][1] = Math.max(res[res.length - 1][1], end);
		} else {
			res.push([start, end]);
		}
	}

	return res;
}

export default insert;
