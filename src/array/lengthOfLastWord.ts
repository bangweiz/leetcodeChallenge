function lengthOfLastWord(s: string): number {
	const str = s.trim();
	let res = 0;
	for (let i = str.length - 1; i >= 0; i--) {
		if (str[i] === " ") {
			break;
		}
		res++;
	}

	return res;
}

export default lengthOfLastWord;
