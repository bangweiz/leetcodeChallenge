function lengthOfLongestSubstring(s: string): number {
	if (s === "") {
		return 0;
	}
	const map = new Map<string, number>([[s[0], 1]]);
	let count = 1;
	let left = 0;
	let right = 0;
	while (right < s.length) {
		if (map.size < right - left + 1) {
			if (left === right) {
				right++;
				addChar(s[right]);
			}
			removeChar(s[left]);
			left++;
		} else {
			count = Math.max(count, map.size);
			right++;
			addChar(s[right]);
		}
	}
	return count;

	function addChar(c: string) {
		map.set(c, (map.get(c) || 0) + 1);
	}

	function removeChar(c: string) {
		const count = map.get(c)!;
		if (count === 1) {
			map.delete(c);
		} else {
			map.set(c, count - 1);
		}
	}
}

export default lengthOfLongestSubstring;
