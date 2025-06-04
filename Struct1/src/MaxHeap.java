import java.util.Arrays;

public class MaxHeap {
    private int[] heap; // 用于存储堆的数组
    private int size;   // 当前堆的大小

    // 构造函数，初始化堆
    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // 获取父节点的索引
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // 获取左子节点的索引
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // 获取右子节点的索引
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // 插入元素到堆中
    public void insert(int value) {
        if (size == heap.length) {
            // 如果堆满了，扩容
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        // 将新元素插入到堆的末尾
        heap[size] = value;
        size++;
        // 上浮操作，调整堆
        siftUp(size - 1);
    }

    // 上浮操作
    private void siftUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            // 与父节点交换
            int temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;
            i = parent(i);
        }
    }

    // 删除堆顶元素
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        // 获取堆顶元素
        int max = heap[0];
        // 将最后一个元素移到堆顶
        heap[0] = heap[size - 1];
        size--;
        // 下沉操作，调整堆
        siftDown(0);
        return max;
    }

    // 下沉操作
    private void siftDown(int i) {
        while (true) {
            int largest = i;
            int left = leftChild(i);
            int right = rightChild(i);

            // 比较左子节点
            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            // 比较右子节点
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            // 如果最大值是当前节点，说明已经调整完成
            if (largest == i) {
                break;
            }

            // 与最大子节点交换
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            // 继续调整
            i = largest;
        }
    }

    // 构建堆（从无序数组构建）
    public void buildHeap(int[] arr) {
        heap = Arrays.copyOf(arr, arr.length);
        size = arr.length;
        // 从最后一个非叶子节点开始调整
        for (int i = parent(size - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 获取堆顶元素
    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // 打印堆
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    // 测试代码
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        // 插入元素
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);

        System.out.println("堆的内容：");
        maxHeap.printHeap();

        // 获取堆顶元素
        System.out.println("堆顶元素：" + maxHeap.getMax());

        // 删除堆顶元素
        System.out.println("删除堆顶元素：" + maxHeap.extractMax());
        System.out.println("删除后的堆：");
        maxHeap.printHeap();

        // 从无序数组构建堆
        int[] arr = {12, 11, 13, 5, 6, 7};
        maxHeap.buildHeap(arr);
        System.out.println("从无序数组构建的堆：");
        maxHeap.printHeap();
    }
}