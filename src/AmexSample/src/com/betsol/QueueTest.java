package com.betsol;



/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;


class QueueTest {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int n = Integer.valueOf(input);
		// creating object of class arrayQueue
		TestQueue queue = new TestQueue(n);
		input = br.readLine();
		String[] inputSplit = input.split("\\s+");
		for (int i = 0; i < inputSplit.length; i++) {
			queue.insert(Integer.valueOf(inputSplit[i]));
		}
		int opt = Integer.valueOf(br.readLine());
		if (opt == 0) {
			queue.remove();
		} else if (opt == 1) {

			int i = Integer.valueOf(br.readLine());
			queue.insert(i);
		}
		queue.display();

       // System.out.println("Hello World!");
    }
}

class TestQueue {
		protected int Queue[];
		protected int front, rear, size, len;

		public TestQueue(int n) {
			size = n;
			len = 0;
			Queue = new int[size];
			front = -1;
			rear = -1;
		}

		private boolean isEmpty() {
			return front == -1;
		}


		public int peek() {
			if (isEmpty())
				throw new NoSuchElementException("Underflow Exception");
			return Queue[front];
		}

		public void insert(int i) {

			if (rear == -1) {
				front = 0;
				rear = 0;
				Queue[rear] = i;
			} else if (rear + 1 >= size) {
				size = size + 1;
				Queue = Arrays.copyOf(Queue, size);
				rear = rear + 1;
				Queue[rear] = i;
			} else if (rear + 1 < size) {
				Queue[++rear] = i;
			}
			len++;
		}

		public int remove() {
			if (isEmpty())
				throw new NoSuchElementException("Underflow Exception");
			else {
				len--;
				int ele = Queue[front];
				if (front == rear) {
					front = -1;
					rear = -1;
				} else
					front++;
				return ele;
			}
		}

		public void display() {
			//System.out.print("\nQueue = ");
			if (len == 0) {
				System.out.print("Empty\n");
				return;
			}
			for (int i = front; i <= rear; i++)
				System.out.print(Queue[i] + " ");
			System.out.println();
		}
	}

