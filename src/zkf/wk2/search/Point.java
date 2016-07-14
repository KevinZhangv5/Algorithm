package zkf.wk2.search;


class Point {

	public int[] next = new int[27]; // 存储直接后继
	public int pn = 0; // 与之相邻元素的个数（后继个数）

	public Point() {
		
	}
}
