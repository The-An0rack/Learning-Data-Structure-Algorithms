class ArrayStack {
    int arr[];
    int top;
    int size;

    ArrayStack(int size) {
        arr = new int[size];
        this.size = size;
        this.top = -1;
    }

    void push(int ele) {
        if(top < size - 1) {
            top++;
            arr[top] = ele;
        } else {
            System.out.println("Overflow");
        }
    }

    int pop() {
        if(top == -1) {
            System.out.println("Underflow");
            return -1;
        } else {
            top--;
            return arr[top+1];
        }
    }

    boolean isEmpty() {
        if(top == -1) {
            return true;
        } else {
            return false;
        }
    }

    int peek() {
        if(top == -1) {
            return -1;
        } else {
            return arr[top];
        }
    }
}
