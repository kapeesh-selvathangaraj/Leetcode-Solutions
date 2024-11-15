class MedianFinder {
    private PriorityQueue<Integer> lowerHalf; // Max-Heap
    private PriorityQueue<Integer> upperHalf; // Min-Heap

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a); // Max-Heap
        upperHalf = new PriorityQueue<>(); // Min-Heap
    }

    public void addNum(int num) {
        lowerHalf.offer(num);
        upperHalf.offer(lowerHalf.poll());

        if (lowerHalf.size() < upperHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }
}