package homework.ArrayMax;

class ArrayMax {

    // Task #1
    static int findSmallestTransaction(int[] transactions) {
        var minTransaction = Integer.MIN_VALUE;

        for (int transaction : transactions) {
            minTransaction = Math.max(minTransaction, transaction);
        }

        return minTransaction;
    }

    // Task #2
    static int findBestStudentMistakes(int[] students) {
        var bestStudent = students[0];

        for (int student : students) {
            bestStudent = Math.min(bestStudent, student);
        }

        return bestStudent;
    }

    // Task #3
    static double findAverageTime(int[] times) {
        var sum = 0L;

        for (int time : times) {
            sum += time;
        }

        return (double) sum / times.length;
    }

    // Task #4
    static int findMostProfitableClient(int[][] income) {
        var maxIncome = 0;
        var clientInex = 0;

        for (var i = 0; i < income.length; i++) {

            var totalIncome = 0;
            for (var j = 0; j < income[i].length; j++) {
                totalIncome += income[i][j];
            }

            if (totalIncome > maxIncome) {
                maxIncome = totalIncome;
                clientInex = i;
            }
        }

        return clientInex;
    }
}
