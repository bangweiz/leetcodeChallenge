function isPalindrome(s: string): boolean {
	const lowerS = s.toLowerCase();
	let left = 0;
	let right = s.length - 1;
	while (left < right) {
		if (!isValidChar(left)) {
			left++;
			continue;
		}
		if (!isValidChar(right)) {
			right--;
			continue;
		}
		if (lowerS[left] !== lowerS[right]) {
			return false;
		}
		left++;
		right--;
	}

	return true;

	function isValidChar(i: number): boolean {
		return (
			(48 <= lowerS.charCodeAt(i) && lowerS.charCodeAt(i) <= 57) ||
			(97 <= lowerS.charCodeAt(i) && lowerS.charCodeAt(i) <= 122)
		);
	}
}

export default isPalindrome;
