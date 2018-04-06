package nickleby.algorithms.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Elevators {

    private static final Integer[] weights = {40, 40, 100, 80, 20};
    private static final Integer[] floors = {3, 3, 2, 2, 3};

    private static class Elevator {
        public Integer capacity;
        public Integer maxWeight;
        public List<Integer> weights = new ArrayList<>();
        public Integer tempWeight = 0;
        public Integer tempCapacity = 0;
        public Set<Integer> floors = new HashSet<>();
        public Integer count = 0;

        public Elevator(Integer capacity, Integer maxWeight) {
            this.capacity = capacity;
            this.maxWeight = maxWeight;
        }

        public Elevator enter(Integer weight, Integer floor) {
            if(capacity < tempCapacity + 1 || maxWeight < tempWeight + weight) {
               finish();
            }

            weights.add(weight);
            floors.add(floor);
            tempCapacity++;
            tempWeight += weight;

            return this;
        }

        public Elevator finish() {
            count += floors.size() + 1;
            weights = new ArrayList<>();
            floors = new HashSet<>();
            tempWeight = 0;
            tempCapacity = 0;

            return this;
        }
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator(5, 200);

        IntStream.range(0, weights.length).boxed().forEach(i -> elevator.enter(weights[i], floors[i]));

        elevator.finish();

        System.out.println(elevator.count);
    }
}
