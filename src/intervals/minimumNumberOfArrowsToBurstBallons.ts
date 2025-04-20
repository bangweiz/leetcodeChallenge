function findMinArrowShots(points: number[][]): number {
	points.sort((a, b) => {
		if (a[0] === b[0]) {
			return a[1] - b[1];
		}
		return a[0] - b[0];
	});

	let res = 0;
	let refinedRange = points[0];
	for (const point of points) {
		if (point[0] > refinedRange[1]) {
			res++;
			refinedRange = point;
		} else {
			refinedRange[0] = Math.max(refinedRange[0], point[0]);
			refinedRange[1] = Math.min(refinedRange[1], point[1]);
		}
	}
	return res + 1;
}

export default findMinArrowShots;
