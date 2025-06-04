public class LinkedList {
    // 定义链表节点类
    private static class Node {
        int data;       // 数据域
        Node next;      // 指针域，指向下一个节点

        // 构造函数
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // 链表的头节点

    // 构造函数，初始化空链表
    public LinkedList() {
        this.head = null;
    }

    // 在链表头部插入节点
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 在链表尾部插入节点
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 在指定位置插入节点
    public void insertAtPosition(int position, int data) {
        if (position < 0) {
            throw new IllegalArgumentException("Position must be non-negative");
        }
        if (position == 0) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // 删除指定位置的节点
    public void deleteAtPosition(int position) {
        if (position < 0 || head == null) {
            throw new IllegalArgumentException("Invalid position or empty list");
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        current.next = current.next.next;
    }

    // 查找指定值的节点，返回其位置（从0开始），未找到返回-1
    public int find(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    // 打印链表
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 测试代码
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // 插入节点
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtHead(5);
        list.insertAtPosition(2, 15);

        System.out.println("链表内容：");
        list.printList();

        // 查找节点
        System.out.println("查找值为20的节点位置：" + list.find(20));

        // 删除节点
        list.deleteAtPosition(2);
        System.out.println("删除位置为2的节点后，链表内容：");
        list.printList();
    }
}