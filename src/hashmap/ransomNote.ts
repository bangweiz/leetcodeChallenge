function canConstruct(ransomNote: string, magazine: string): boolean {
	const letterCount: number[] = new Array(26).fill(0);
	for (const letter of magazine) {
		letterCount[letter.charCodeAt(0) - 97]++;
	}
	for (const letter of ransomNote) {
		letterCount[letter.charCodeAt(0) - 97]--;
	}
	return letterCount.every((count) => count >= 0);
}

export default canConstruct;
