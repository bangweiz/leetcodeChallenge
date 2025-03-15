function fullJustify(words: string[], maxWidth: number): string[] {
	const groups: string[][] = [[]];
	let size = 0;
	words.forEach((word) => {
		const group = groups[groups.length - 1];
		const currentSize = size + word.length + group.length;
		if (currentSize <= maxWidth) {
			group.push(word);
			size += word.length;
		} else {
			const nextGroup = [word];
			groups.push(nextGroup);
			size = word.length;
		}
	});
	const res: string[] = [];
	groups.forEach((group, index) => {
		if (index === groups.length - 1 || group.length === 1) {
			res.push(group.join(" ").padEnd(maxWidth, " "));
			return;
		}
		const wordSize = group.reduce((acc, cur) => acc + cur.length, 0);
		const spaceCount = Math.floor((maxWidth - wordSize) / (group.length - 1));
		const extraSpaceCount = (maxWidth - wordSize) % (group.length - 1);
		for (let i = 0; i < extraSpaceCount; i++) {
			group[i] += " ";
		}
		const pad = "".padEnd(spaceCount, " ");
		res.push(group.join(pad));
	});
	return res;
}

export default fullJustify;
