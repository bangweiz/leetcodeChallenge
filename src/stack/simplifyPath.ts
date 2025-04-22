function simplifyPath(path: string): string {
	const paths = path.split("/");
	const pathStack: string[] = [];
	for (const p of paths) {
		switch (p) {
			case ".":
				break;
			case "..":
				pathStack.pop();
				break;
			case "":
				break;
			default:
				pathStack.push(p);
				break;
		}
	}
	return `/${pathStack.join("/")}`;
}

export default simplifyPath;
