function convert(s: string, numRows: number): string {
	if (numRows === 1) {
		return s;
	}
	const rows = new Array(numRows).fill("");
	const size = numRows * 2 - 2;
	s.split("").forEach((char, index) => {
		const i = index % size;
		if (i < numRows) {
			rows[i] += char;
		} else {
			rows[numRows - ((i % numRows) + 2)] += char;
		}
	});
	return rows.join("");
}

export default convert;
