function intToRoman(num: number): string {
	let res = "";
	const romanChars = [["I", "V", "X"], ["X", "L", "C"], ["C", "D", "M"], ["M"]];
	let index = 0;
	let numbers = num;
	while (numbers > 0) {
		const remaining = numbers % 10;
		if (remaining < 4) {
			for (let i = 0; i < remaining; i++) {
				res = romanChars[index][0] + res;
			}
		} else if (remaining === 4) {
			res = romanChars[index][0] + romanChars[index][1] + res;
		} else if (remaining < 9) {
			for (let i = 0; i < remaining - 5; i++) {
				res = romanChars[index][0] + res;
			}
			res = romanChars[index][1] + res;
		} else {
			res = romanChars[index][0] + romanChars[index][2] + res;
		}
		numbers = Math.floor(numbers / 10);
		index++;
	}
	return res;
}

export default intToRoman;
