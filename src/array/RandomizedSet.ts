// Insert Delete GetRandom O(1)
class RandomizedSet {
	private map = new Map<number, number>();
	private list: number[] = [];
	private lastValidIndex = -1;

	insert(val: number): boolean {
		if (this.map.has(val)) {
			return false;
		}
		this.lastValidIndex++;
		this.map.set(val, this.lastValidIndex);
		if (this.list.length === this.lastValidIndex) {
			this.list.push(val);
		} else {
			this.list[this.lastValidIndex] = val;
		}
		return true;
	}

	remove(val: number): boolean {
		const index = this.map.get(val);
		if (index === undefined) {
			return false;
		}
		this.map.delete(val);
		if (this.lastValidIndex !== index) {
			[this.list[index], this.list[this.lastValidIndex]] = [
				this.list[this.lastValidIndex],
				this.list[index],
			];
			this.map.set(this.list[index], index);
		}
		this.lastValidIndex--;
		return true;
	}

	getRandom(): number {
		const index = Math.floor(Math.random() * (this.lastValidIndex + 1));
		return this.list[index];
	}
}

export default RandomizedSet;
