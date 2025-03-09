function longestCommonPrefix(strs: string[]): string {
	const arr = strs[0].split("");
	let size = arr.length;
	for (let i = 1; i < strs.length; i++) {
		for (let j = 0; j < size; j++) {
			if (strs[i][j] !== arr[j]) {
				size = j;
				break;
			}
		}
	}
	return arr.slice(0, size).join("");
}

export default longestCommonPrefix;
