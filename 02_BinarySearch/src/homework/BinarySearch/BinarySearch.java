package homework.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static boolean doIKnowThisLanguage(String[] languagesList, String language) {

        var left = 0;
        var right = languagesList.length - 1;

        while (left <= right) {

            var middle = (right + left) / 2;
            int compare = languagesList[middle].compareTo(language);

            if (compare < 0) {
                left = middle + 1;
            } else if (compare > 0) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static class DatingUser {
        public final int iq;
        public final String name;

        public DatingUser(int iq, String name) {
            this.iq = iq;
            this.name = name;
        }
    }

    public static List<String> findUsers(DatingUser[] usersSortedByIq, int lowerIqBound, int professorIq) {

        List<String> userNames = new ArrayList<>();

        var lowerIndex = findLowerUserIndex(usersSortedByIq, lowerIqBound);
        var upperIndex = findUpperUserIndex(usersSortedByIq, professorIq);

        if (lowerIndex == -1 || upperIndex == -1) {
            return userNames;
        }

        for (int i = lowerIndex; i <= upperIndex; i++) {
            userNames.add(usersSortedByIq[i].name);
        }

        return userNames;
    }

    private static int findLowerUserIndex(DatingUser[] usersSortedByIq, int iq) {

        var left = 0;
        var right = usersSortedByIq.length - 1;
        var result = -1;

        while (left <= right) {

            var middle = (right + left) / 2;
            DatingUser datingUser = usersSortedByIq[middle];

            if (datingUser.iq < iq) {
                left = middle + 1;
            } else {
                right = middle - 1;
                result = middle;
            }
        }

        return result;
    }

    private static int findUpperUserIndex(DatingUser[] usersSortedByIq, int iq) {

        var left = 0;
        var right = usersSortedByIq.length - 1;
        var result = -1;

        while (left <= right) {

            var middle = (right + left) / 2;
            DatingUser datingUser = usersSortedByIq[middle];

            if (datingUser.iq < iq) {
                left = middle + 1;
                result = middle;
            } else {
                right = middle - 1;
            }
        }

        return result;
    }

    public static int findPhoneNumber(long[] sortedPhoneNumbers, long phone) {

        var left = 0;
        var right = sortedPhoneNumbers.length - 1;

        while (left <= right) {

            var middle = (left + right) / 2;

            if (sortedPhoneNumbers[middle] < phone) {
                left = middle + 1;
            } else if (sortedPhoneNumbers[middle] > phone) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        left = sortedPhoneNumbers.length - 1;
        right = 0;

        while (left >= right) {

            var middle = (left + right) / 2;

            if (sortedPhoneNumbers[middle] < phone) {
                left = middle - 1;
            } else if (sortedPhoneNumbers[middle] > phone) {
                right = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
