function findSubstring(s: string, words: string[]): number[] {
	const n = words[0].length;
	if (s.length < n * words.length) {
		return [];
	}
	const map = new Map<string, number>();
	const letterMap = new Array(26).fill(0);
	for (const word of words) {
		map.set(word, (map.get(word) || 0) + 1);
		for (const char of word) {
			letterMap[char.charCodeAt(0) - 97]++;
		}
	}

	const res: number[] = [];
	let left = 0;
	let right = n * words.length - 1;
	for (let i = 0; i <= right; i++) {
		letterMap[s[i].charCodeAt(0) - 97]--;
	}
	while (true) {
		if (sameLetters() && canCat(left)) {
			res.push(left);
		}
		if (right === s.length - 1) {
			break;
		}
		letterMap[s[left].charCodeAt(0) - 97]++;
		left++;
		right++;
		letterMap[s[right].charCodeAt(0) - 97]--;
	}

	return res;

	function sameLetters() {
		return letterMap.every((count) => count === 0);
	}

	function canCat(start: number): boolean {
		const dupMap = new Map(map);
		for (let i = 0; i < words.length; i++) {
			const index = start + i * n;
			const word = s.slice(index, index + n);
			const count = dupMap.get(word);
			if (!count) {
				return false;
			}
			if (count === 1) {
				dupMap.delete(word);
			} else {
				dupMap.set(word, count - 1);
			}
		}
		return true;
	}
}

export default findSubstring;
