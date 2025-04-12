function minWindow(s: string, t: string): string {
	const newS = `${s}$`;
	const lowerCaseCount: number[] = new Array(26).fill(0);
	const upperCaseCount: number[] = new Array(26).fill(0);
	for (const c of t) {
		manipulateMap(c, true);
	}

	let res = "";
	let left = 0;
	let right = 0;
	manipulateMap(newS[right], false);
	while (right < newS.length - 1) {
		if (containsT()) {
			if (res.length === 0 || res.length > right - left + 1) {
				res = newS.slice(left, right + 1);
			}
			if (left === right) {
				right++;
				manipulateMap(newS[right], false);
			}
			manipulateMap(newS[left], true);
			left++;
			continue;
		}
		right++;
		manipulateMap(newS[right], false);
	}

	return res;

	function containsT(): boolean {
		return (
			lowerCaseCount.every((count) => count <= 0) &&
			upperCaseCount.every((count) => count <= 0)
		);
	}

	function manipulateMap(c: string, isAdd: boolean) {
		const code = c.charCodeAt(0);
		if (97 <= code && code <= 122) {
			lowerCaseCount[code - 97] += isAdd ? 1 : -1;
		} else {
			upperCaseCount[code - 65] += isAdd ? 1 : -1;
		}
	}
}

export default minWindow;
