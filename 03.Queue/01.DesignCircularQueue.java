class MyCircularQueue {
    
    int front;
    int rear;
    int arr[];
    int size;

    public MyCircularQueue(int k) {
        size = k;
        front = -1;
        rear = -1;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        } else if(isEmpty()) {
            front = 0;
            rear = 0;
            arr[front] = value;
        } else {
            rear = (rear+1) % size;
            arr[rear] = value;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        front = (front+1)%size;
        if(front == (rear + 1)%size) {
            front = rear = -1;
        }
        return true;
    }
    
    public int Front() {
        if(front == -1) {
            return -1;
        }    
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(front == rear && front == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull() {
        if((front == 0 && rear == size - 1) || (rear == front - 1)) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */