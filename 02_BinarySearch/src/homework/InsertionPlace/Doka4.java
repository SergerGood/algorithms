package homework.InsertionPlace;

import examples.Doka3;

public class Doka4 {
    public static int searchRightmostPlayerWithRating(Doka3.Player[] queue, int ratingBand) {

        var left = 0;
        var right = queue.length - 1;
        boolean found = false;

        while (left <= right) {

            var middle = (left + right) / 2;
            if (queue[middle] == null || queue[middle].getRating() < ratingBand) {
                left = middle + 1;
            } else if (queue[middle].getRating() > ratingBand) {
                right = middle - 1;
            } else {
                left = middle + 1;
                found = true;
            }
        }

        return found ? right : -1;
    }

    public static Doka3.Player[] insertPlayerInQueueWithShift(Doka3.Player[] queue, int index, Doka3.Player newPlayer) {

        var newQueue = new Doka3.Player[queue.length];
        for (int i = 0; i < newQueue.length; i++) {
            if (i < index) {
                newQueue[i] = queue[i];
            } else if (i == index) {
                newQueue[i] = newPlayer;
            } else {
                newQueue[i] = queue[i - 1];
            }
        }

        return newQueue;
    }
}
