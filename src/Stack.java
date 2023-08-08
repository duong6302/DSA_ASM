class Stack {
    private String[] items;
    private int top;

    public Stack(int capacity) {
        items = new String[capacity];
        top = -1;
    }

    public void push(String item) {
        try {
            if (isFull()) {
                throw new Exception("Stack is full.");
            }
            top++;
            items[top] = item;
        } catch (Exception e) {
            System.out.println("Error while pushing: " + e.getMessage());
        }
    }

    public String pop() {
        try {
            if (isEmpty()) {
                throw new Exception("Stack is empty.");
            }
            String item = items[top];
            top--;
            return item;
        } catch (Exception e) {
            System.out.println("Error while popping: " + e.getMessage());
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == items.length - 1;
    }
}