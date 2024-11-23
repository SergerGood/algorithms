package examples;

public class PlayersQueue {
    static class Player {
        int ratingBand;
        String nickName;

        public Player(int ratingBand, String nickName) {
            this.ratingBand = ratingBand;
            this.nickName = nickName;
        }

        public int getRatingBand() {
            return ratingBand;
        }

        public String getNickName() {
            return nickName;
        }
    }


    public static int searchLeftmostPlayerWithRating(Player[] queue, int search) {
        int left = 0;
        int right = queue.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (queue[middle].getRatingBand() < search) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Player[] queue = new Player[]{
                new Player(1000, "Crowbar Freeman"),
                new Player(1000, "London Mollarik"),
                new Player(1010, "London Mollarik 10"),
                new Player(1012, "London Mollarik 12"),
                new Player(1014, "London Mollarik 14"),
                new Player(1016, "London Mollarik 16"),
                new Player(1016, "London Mollarik 18"),
                new Player(1500, "Raziel of Kain"),
                new Player(1500, "Gwinter of Rivia"),
                new Player(1500, "Slayer of Fate"),
                new Player(3000, "Jon Know"),
                new Player(4000, "Caius Cosades")
        };

        System.out.println("1011:" + queue[searchLeftmostPlayerWithRating(queue, 1011)].getNickName());
        System.out.println("1013:" + queue[searchLeftmostPlayerWithRating(queue, 1013)].getNickName());
        System.out.println("1015:" + queue[searchLeftmostPlayerWithRating(queue, 1015)].getNickName());
        System.out.println("1017:" + queue[searchLeftmostPlayerWithRating(queue, 1017)].getNickName());
    }

}
