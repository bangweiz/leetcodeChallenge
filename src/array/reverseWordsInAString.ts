function reverseWords(s: string): string {
	const words: string[] = [];
	let end = -1;
	for (let i = s.length - 1; i >= 0; i--) {
		if (s[i] === " ") {
			if (end === -1) {
				continue;
			}
			words.push(s.substring(i + 1, end + 1));
			end = -1;
		} else {
			if (end === -1) {
				end = i;
			}
		}
	}
	if (end !== -1) {
		words.push(s.substring(0, end + 1));
	}
	return words.join(" ");
}

export default reverseWords;
