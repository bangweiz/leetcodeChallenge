function isSubsequence(s: string, t: string): boolean {
	let pointerS = 0;
	let pointerT = 0;
	while (pointerS < s.length) {
		if (pointerT >= t.length) {
			return false;
		}
		if (s[pointerS] === t[pointerT]) {
			pointerS++;
			pointerT++;
		} else {
			pointerT++;
		}
	}
	return true;
}

export default isSubsequence;
