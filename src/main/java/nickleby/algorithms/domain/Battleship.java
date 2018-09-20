package nickleby.algorithms.domain;

import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Battleship {


    @ToString
    private static class PlayBoard {
        private List<Ship> ships;

        PlayBoard(String shipLocationsString, String shots) {
            setShips(shipLocationsString);
            fireShots(shots);
        }

        private List<String> extractShipLocations(String shipLocationsString) {
            return Arrays.asList(shipLocationsString.split(","));
        }

        private void setShips(String shipLocationsString) {
            List<String> shipLocations = extractShipLocations(shipLocationsString);

            ships = shipLocations.stream().map(Ship::new).collect(Collectors.toList());
        }

        private void fireShots(String shotsString) {
            List<String> shots = Arrays.asList(shotsString.split(" "));

            ships = ships.stream().peek(ship -> ship.checkShots(shots)).collect(Collectors.toList());
        }


        String countHitsAndSunk() {
            Integer numberHits = 0;
            Integer numberSunk = 0;

            for(Ship ship : ships) {
                numberHits += ship.checkHits();
                if(ship.isSunk()) {
                    numberSunk++;
                    numberHits--;
                }
            }

            return numberSunk + "," + numberHits;
        }
    }


    @ToString
    private static class Ship {
        private Integer length;
        private Set<String> notHit;
        private Integer hits = 0;

        Ship(String shipLocation) {
            extractDimensions(shipLocation);
            length = notHit.size();
        }

        private void extractDimensions(String shipLocation) {
            this.notHit = new HashSet<>(Arrays.asList(shipLocation.split(" ")));
        }

        Ship checkShots(List<String> shots) {
            notHit = notHit.stream().filter(area -> !shots.contains(area)).collect(Collectors.toSet());

            return this;
        }

        Integer checkHits() {
            hits = length - notHit.size();

            return hits;
        }

        Boolean isSunk() {
            return hits.equals(length);
        }
    }

    public static void main(String[] args) {
 
    }
}
