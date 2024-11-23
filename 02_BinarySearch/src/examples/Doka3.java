package examples;

public class Doka3 {
    public static class Player {
        private final int rating;
        private final String nickName;

        public Player(int rating, String nickName) {
            this.rating = rating;
            this.nickName = nickName;
        }

        public int getRating() {
            return rating;
        }

        public String getNickName() {
            return nickName;
        }

        @Override
        public String toString() {
            return "P{" + nickName + ":" + rating + "}";
        }
    }

    // Наша рейтинговая таблица выглядит примерно так
    static Player ratings[] = new Player[]{
            /*0*/ new Player(1100, "Crowbar Freeman"),
            /*1*/ new Player(1200, "London Mollarik"),
            // new Player(1600, "Shmike")
            /*2*/ new Player(1600, "Raziel of Kain"),
            /*3*/ new Player(1600, "Gwinter of Rivia"),
            /*4*/ new Player(1600, "Slayer of Fate"),
            /*5*/ new Player(3000, "Jon Know"),
            /*6*/ new Player(4000, "Caius Cosades"),
    };


    public static int findSpot(Player[] array, Player newPlayer) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle].rating < newPlayer.rating) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int spot = findSpot(ratings, new Player(1600, "Shmike"));
        System.out.println(spot);
    }

}

