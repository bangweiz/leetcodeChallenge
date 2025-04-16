function groupAnagrams(strs: string[]): string[][] {
	const map = new Map<string, string[]>();
	for (const str of strs) {
		const mapper: number[] = new Array(26).fill(0);
		for (let i = 0; i < str.length; i++) {
			mapper[str.charCodeAt(i) - 97]++;
		}
		const key = mapper.join(",");
		if (map.has(key)) {
			map.get(key)!.push(str);
		} else {
			map.set(key, [str]);
		}
	}

	const res: string[][] = [];
	for (const [_, value] of map) {
		res.push(value);
	}
	return res;
}

export default groupAnagrams;
