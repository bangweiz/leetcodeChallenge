package FindMedianfromDataStream;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;
    int count;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((Double a, Double b) -> (int)(b - a));
        count = 0;
    }

    public void addNum(int num) {
        count++;
        int minHeapSize = count / 2 + 1;
        maxHeap.add((double)num);
        if (minHeap.size() < minHeapSize) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.peek() < maxHeap.peek()) {
            double min = minHeap.poll();
            minHeap.add(maxHeap.poll());
            maxHeap.add(min);
        }
    }

    public double findMedian() {
        if (count % 2 == 1) {
            return minHeap.peek();
        }
        double v1 = minHeap.poll();
        double v2 = minHeap.peek();
        minHeap.add(v1);
        return (v1 + v2) / 2;
    }
}
