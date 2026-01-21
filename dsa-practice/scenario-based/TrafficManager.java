package scenario_based;

class Vehicle {
	String vehicleNumber;
	
	public Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	@Override
	public String toString() {
		return vehicleNumber;
	}
}

class Node {
	Vehicle data;
	Node next;
	
	public Node(Vehicle vehicle) {
		this.data = vehicle;
		this.next = null;
	}
}

class WaitingQueue {
	int startIdx, endIdx, capacity, currSize;
	Vehicle[] vehicle;
	
	public WaitingQueue (int capacity) {
		this.capacity = capacity;
		this.vehicle = new Vehicle[capacity];
		this.startIdx = 0;
		this.endIdx = -1;
		this.currSize = 0;
	}
	
	public void enqueue(Vehicle newVehicle) {
		if (currSize == capacity) {
			System.out.println("Waiting Queue Is Full.");
		} else {
			endIdx++;
			vehicle[endIdx] = newVehicle;
			currSize++;
		}
	}
	
	public Vehicle dequeue() {
		if (currSize == 0) {
			System.out.println("Waiting Queue Is Empty.");
			return null;
		} else {
			Vehicle tempVehicle = vehicle[startIdx];
			startIdx++;
			currSize--;
			return tempVehicle;			
		}
	}

	public boolean isEmpty() {
		if(currSize == 0) return true;
		return false;
	}
}

public class TrafficManager {
	Node head, tail;
	int maxCapacity, currCount;
	WaitingQueue wQueue;
	
	public TrafficManager(int maxCapacity, int wQueueCapacity) {
		this.head = null;
		this.tail = null;
		this.currCount = 0;
		this.maxCapacity = maxCapacity;
		wQueue = new WaitingQueue(wQueueCapacity);
	}
	
	public void addVehicle(Vehicle vehicle) {
		if (currCount == maxCapacity) {
			wQueue.enqueue(vehicle);
			System.out.println("Roundabout is full vehicle " + vehicle.vehicleNumber + " added to waiting queue.");
		} else {
			if (head == null) {
				Node newVehicle = new Node(vehicle);
				head = newVehicle;
				tail = newVehicle;
				newVehicle.next = newVehicle;
				currCount++;
				System.out.println("Vehicle " + vehicle.vehicleNumber + " added to roundabout.");
			} else {
				Node newVehicle = new Node(vehicle);
				tail.next = newVehicle;
				tail = newVehicle;
				tail.next = head;
				currCount++;
				System.out.println("Vehicle " + vehicle.vehicleNumber + " added to roundabout.");
			}
		}
	}
	
	public void removeVehicle() {
		if (head == null) {
			System.out.println("Roundabout is empty");
			return;
		} else {
			if (head == tail) {
				System.out.println("Vehicle " + head.data + " removed from roundabout.");
				head = tail = null;
				currCount--;
			} else {
				System.out.println("Vehicle " + head.data + " removed from roundabout.");
				head = head.next;
				tail.next = head;
				currCount--;
			}
		}
		if (!wQueue.isEmpty()) {
			Vehicle dequeVehicle = wQueue.dequeue();
			addVehicle(dequeVehicle);
		}
	}
	
	public void printRoundabout() {
	    if (head == null) {
	        System.out.println("Roundabout is empty.");
	        return;
	    }

	    System.out.print("Roundabout: ");
	    Node temp = head;

	    do {
	        System.out.print(temp.data + " -> ");
	        temp = temp.next;
	    } while (temp != head);

	    System.out.println("(back to start)");
	}
	
	public static void main(String[] args) {
		TrafficManager tm = new TrafficManager(2, 3);

	    Vehicle v1 = new Vehicle("KA01");
	    Vehicle v2 = new Vehicle("KA02");
	    Vehicle v3 = new Vehicle("KA03");
	    Vehicle v4 = new Vehicle("KA04");

	    tm.addVehicle(v1);
	    tm.addVehicle(v2);
	    tm.addVehicle(v3);   
	    tm.addVehicle(v4);

	    tm.printRoundabout();

	    tm.removeVehicle();
	    tm.printRoundabout();

	    tm.removeVehicle();
	    tm.printRoundabout();
	}
}
