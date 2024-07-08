import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge1 {

    public static void main(String[] args) {
        LRUCaching caching = new LRUCaching(10_000);
        caching.put(1, 10);

        System.out.println(caching.get(1));

        //1. Test put/get 1 item

        //2. Test maxSize 10_000 keys
    }

    public static class LRUCaching {

        final int maxSize;
        private Queue<Integer> _queue;
        private Map<Integer, Integer> _map = new HashMap<>();

        public LRUCaching(int maxSize) {
            this.maxSize = maxSize;
            _queue = new ArrayBlockingQueue<>(maxSize);
        }

        public Integer get(int key) {
            return _map.getOrDefault(key, -1); //-1: not exist key
        }

        synchronized public void put(int key, Integer value) {
            int curSize = _queue.size();
            if (curSize >= maxSize) {
                //pop oldest key
                Integer oldKey = _queue.poll();
                _map.remove(oldKey);
            }
            _queue.add(key);
            _map.put(key, value);
        }

        public void put2(int key, Integer value) {
            ReentrantLock reentrantLock = new ReentrantLock();
            reentrantLock.lock();
            try {
                int curSize = _queue.size();
                if (curSize >= maxSize) {
                    //pop oldest key
                    Integer oldKey = _queue.poll();
                    _map.remove(oldKey);
                }
                _queue.add(key);
                _map.put(key, value);
            } finally {
                reentrantLock.unlock();
            }

        }


        public int size() {
            return this._map.size();
        }
    }
}
