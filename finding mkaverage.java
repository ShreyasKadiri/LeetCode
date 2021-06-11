public class MKAverage {

    int m, k;
    Deque<Integer> queue = new ArrayDeque();
    SortedList l1 = new SortedList();
    SortedList l2 = new SortedList();
    SortedList l3 = new SortedList();

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        queue.addLast(num);
        // add in the proper place
        if (l1.isEmpty() || num <= l1.getLast()) {
            l1.add(num);
        } else if (l2.isEmpty() || num <= l2.getLast()) {
            l2.add(num);
        } else {
            l3.add(num);
        }
        if (queue.size() > m) {
            int removedElement = queue.removeFirst();
            // remove in the proper place
            if (l1.contains(removedElement)) {
                l1.remove(removedElement);
            } else if (l2.contains(removedElement)) {
                l2.remove(removedElement);
            } else {
                l3.remove(removedElement);
            }
        }
		// adjust size of l1, l2, l3
        if (l1.size > k) {
            l2.add(l1.removeLast());
        } else if (l1.size < k && !l2.isEmpty()) {
            l1.add(l2.removeFirst());
        }
        if (l2.size > m - k - k) {
            l3.add(l2.removeLast());
        } else if (l2.size < m - k - k && !l3.isEmpty()) {
            l2.add(l3.removeFirst());
        }
    }

    public int calculateMKAverage() {
        if (l1.size + l2.size + l3.size < m) {
            return -1;
        }
        return (int)Math.floor((double)(l2.sum) / (l2.size));
    }

    static class SortedList {
        long sum;
        int size;
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        public void add(int n) {
            tm.put(n, tm.getOrDefault(n, 0) + 1);
            sum += n;
            size++;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean contains(int n) {
            return tm.containsKey(n);
        }

        public void remove(int n) {
            if (!tm.containsKey(n)) {
                return;
            }
            int count = tm.get(n);
            sum -= n;
            size--;
            if (count == 1) {
                tm.remove(n);
            } else {
                tm.put(n, count - 1);
            }
        }

        public int removeLast() {
            Map.Entry<Integer, Integer> lastEntry = tm.lastEntry();
            if (lastEntry.getValue() == 1) {
                tm.remove(lastEntry.getKey());
            } else {
                tm.put(lastEntry.getKey(), lastEntry.getValue() - 1);
            }
            sum -= lastEntry.getKey();
            size--;
            return lastEntry.getKey();
        }

        public int removeFirst() {
            Map.Entry<Integer, Integer> firstEntry = tm.firstEntry();
            if (firstEntry.getValue() == 1) {
                tm.remove(firstEntry.getKey());
            } else {
                tm.put(firstEntry.getKey(), firstEntry.getValue() - 1);
            }
            sum -= firstEntry.getKey();
            size--;
            return firstEntry.getKey();
        }

        public int getLast() {
            return tm.lastKey();
        }

        public int getFirst() {
            return tm.firstKey();
        }
    }
	
}
