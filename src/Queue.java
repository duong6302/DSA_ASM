class Queue {
    private String[] items;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        items = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String item) {
       
            if (isFull()) {
                throw new Exception("Queue is full.");
            }
            rear = (rear + 1) % items.length;
            items[rear] = item;
            size++;
        } 
    

    public String dequeue() {
        try {
            if (isEmpty()) {
                throw new Exception("Queue is empty.");
            }
            String item = items[front];
            front = (front + 1) % items.length;
            size--;
            return item;
        } catch (Exception e) {
            System.out.println("Error while dequeuing: " + e.getMessage());
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }
}