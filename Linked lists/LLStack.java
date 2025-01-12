public class LLStack{
    Cell first;

	public class Cell {
        int head;
        Cell tail;
    
        public Cell(int val, Cell tl) {
            this.head = val;
            this.tail = tl;
        }
    }  
    public LLStack(int n) {
        first = null;
    }

	public void push(int val) {
		Cell newC = new Cell(val, first);
		first = newC;
	}

	public int pop() throws Exception {
		if (first == null) {
			throw new Exception("Tried to pop empty stack");
		}
		int tmp = first.head;
		first = first.tail;
		return tmp;
	}
}