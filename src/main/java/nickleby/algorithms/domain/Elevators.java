package nickleby.algorithms.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Elevators {

    private static final Integer[] weights = {40, 40, 100, 80, 20};
    private static final Integer[] floors = {3, 3, 2, 2, 3};

    private static class Elevator {
        final Integer capacity;
        final Integer maxWeight;
        Integer currentWeight = 0;
        Integer currentCapacity = 0;
        Set<Integer> floors = new HashSet<>();
        Integer count = 0;

        Elevator(Integer capacity, Integer maxWeight) {
            this.capacity = capacity;
            this.maxWeight = maxWeight;
        }

        boolean isFull() { return capacity < currentCapacity + 1; }

        private boolean overWeight(Integer weight) {
            return maxWeight < currentWeight + weight;
        }

        void enter(Integer weight, Integer floor) {
            if(isFull() || overWeight(weight)) { dropOffOccupants(); }

            addOccupant(weight, floor);
        }

        void addOccupant(Integer weight, Integer floor) {
            floors.add(floor);
            currentCapacity++;
            currentWeight += weight;
        }

        void dropOffOccupants() {
            count += floors.size() + 1;
            floors = new HashSet<>();
            currentWeight = 0;
            currentCapacity = 0;
        }

        void finish() { this.dropOffOccupants(); }
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator(5, 200);

        IntStream.range(0, weights.length).boxed().forEach(i -> elevator.enter(weights[i], floors[i]));

        elevator.finish();

        System.out.println(elevator.count);
    }
}
