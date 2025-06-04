


import java.util.Arrays;

public class ArrayStack {
    private int[] stack; // 用于存储栈元素的数组
    private int top;     // 栈顶指针，指向栈顶元素的索引

    // 构造函数，初始化栈
    public ArrayStack(int capacity) {
        stack = new int[capacity];
        top = -1; // 栈为空时，top为-1
    }

    // 入栈操作
    public void push(int value) {
        if (top == stack.length - 1) {
            // 栈满时扩容
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        stack[++top] = value; // 先将top加1，然后存储元素
    }

    // 出栈操作
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--]; // 返回栈顶元素，并将top减1
    }

    // 查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 获取栈的大小
    public int size() {
        return top + 1;
    }

    // 打印栈的内容
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // 测试代码
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        // 入栈
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("栈的内容：");
        stack.printStack();

        // 查看栈顶元素
        System.out.println("栈顶元素：" + stack.peek());

        // 出栈
        System.out.println("出栈元素：" + stack.pop());
        System.out.println("栈的内容：");
        stack.printStack();

        // 判断是否为空
        System.out.println("栈是否为空：" + stack.isEmpty());
    }
}