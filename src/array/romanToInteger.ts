function romanToInt(s: string): number {
	const map = new Map([
		["I", 1],
		["V", 5],
		["X", 10],
		["L", 50],
		["C", 100],
		["D", 500],
		["M", 1000],
	]);

	let res = 0;
	for (let i = 0; i < s.length; i++) {
		const currentValue = map.get(s[i])!;
		if (i < s.length - 1 && isNegative(s[i], s[i + 1])) {
			res -= currentValue;
		} else {
			res += currentValue;
		}
	}

	function isNegative(char1: string, char2: string) {
		return (
			(char1 === "I" && (char2 === "V" || char2 === "X")) ||
			(char1 === "X" && (char2 === "L" || char2 === "C")) ||
			(char1 === "C" && (char2 === "D" || char2 === "M"))
		);
	}

	return res;
}

export default romanToInt;
