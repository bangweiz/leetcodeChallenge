function merge(intervals: number[][]): number[][] {
	intervals.sort((a, b) => a[0] - b[0]);

	const res = [intervals[0]];
	for (const interval of intervals) {
		if (interval[0] <= res[res.length - 1][1]) {
			res[res.length - 1][1] = Math.max(res[res.length - 1][1], interval[1]);
		} else {
			res.push(interval);
		}
	}
	return res;
}

export default merge;
