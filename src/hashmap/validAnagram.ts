function isAnagram(s: string, t: string): boolean {
	if (s.length !== t.length) {
		return false;
	}
	const map: number[] = new Array(26).fill(0);
	for (let i = 0; i < s.length; i++) {
		map[s.charCodeAt(i) - 97]++;
		map[t.charCodeAt(i) - 97]--;
	}
	return map.every((count) => count === 0);
}

export default isAnagram;
