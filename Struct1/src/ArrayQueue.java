public class ArrayQueue {
    private int[] queue; // 用于存储队列元素的数组
    private int front;   // 队头指针
    private int rear;    // 队尾指针
    private int size;    // 当前队列的大小

    // 构造函数，初始化队列
    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // 入队操作
    public void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length; // 循环队列
        size++;
    }

    // 出队操作
    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % queue.length; // 循环队列
        size--;
        return value;
    }

    // 获取队头元素
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取队列的大小
    public int size() {
        return size;
    }

    // 打印队列
    public void printQueue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    // 测试代码
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(5);

        // 入队
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("队列内容：");
        queue.printQueue();

        // 出队
        System.out.println("出队元素：" + queue.dequeue());
        System.out.println("队列内容：");
        queue.printQueue();

        // 查看队头元素
        System.out.println("队头元素：" + queue.peek());

        // 判断是否为空
        System.out.println("队列是否为空：" + queue.isEmpty());
    }
}