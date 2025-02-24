function hIndex(citations: number[]): number {
	citations.sort((a, b) => a - b);
	let h = 0;
	for (let i = citations.length - 1; i >= 0; i--) {
		if (citations[i] >= h + 1) {
			h++;
		} else {
			return h;
		}
	}
	return h;
}

export default hIndex;
