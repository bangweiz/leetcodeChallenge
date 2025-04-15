function wordPattern(pattern: string, s: string): boolean {
	const words = s.split(" ");
	if (pattern.length !== words.length) {
		return false;
	}

	const map1: string[] = new Array(26).fill("");
	const map2 = new Map<string, number>();
	for (let i = 0; i < words.length; i++) {
		const code = pattern.charCodeAt(i) - 97;
		if (map1[code] === "") {
			map1[code] = words[i];
		} else {
			if (map1[code] !== words[i]) {
				return false;
			}
		}
		if (!map2.has(words[i])) {
			map2.set(words[i], code);
		} else {
			if (map2.get(words[i]) !== code) {
				return false;
			}
		}
	}
	return true;
}

export default wordPattern;
