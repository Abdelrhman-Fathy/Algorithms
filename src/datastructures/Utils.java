package datastructures;

public class Utils {
	
	public static int encodeItemPosition(int row, int column, int columnsCount) {
		return (row*columnsCount + column);
	}
	
	public static int  decodeRow(int position, int columnsCount) {
		return (position/columnsCount);
	}
	public static int  decodeColumn(int position, int columnsCount) {
		return (position%columnsCount);
	}
	
	public static boolean  withinArray(int nextRow, int nextColumn, int rowsCount, int  columnsCount) {
		return (nextRow >= 0 && nextRow <rowsCount && nextColumn >= 0 && nextColumn < columnsCount );
	}
	
	public static boolean  withinArray(Node node, int rowsCount, int  columnsCount) {
		return (node.getRow() >= 0 && node.getRow() <rowsCount && node.getColumn() >= 0 && node.getColumn() < columnsCount );
	}
	
	public static class Node<T, V>{
		private int row;
		private int column;
		boolean visited;
		private V feature;

		private T value;
		
		public Node(int row, int column, T value) {
			super();
			this.row = row;
			this.column = column;
			this.value = value;
		}
		
		public Node(int row, int column, T value, V feature) {
			super();
			this.row = row;
			this.column = column;
			this.value = value;
			this.feature = feature;
		}
		
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getColumn() {
			return column;
		}
		public void setColumn(int column) {
			this.column = column;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public V getFeature() {
			return feature;
		}
		public void setFeature(V feature) {
			this.feature = feature;
		}
		
		
	}
	
			
}
