package homeworkTests;

import examples.Doka3;
import homework.InsertionPlace.Doka4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Doka4Test {

    private static final Doka3.Player[] players = new Doka3.Player[]{
            new Doka3.Player(1100, "Crowbar Freeman"),
            new Doka3.Player(1200, "London Mollarik"),
            new Doka3.Player(1600, "Raziel of Kain"),
            new Doka3.Player(1600, "Gwinter of Rivia"),
            new Doka3.Player(1600, "Slayer of Fate"),
            new Doka3.Player(3000, "Jon Know"),
            new Doka3.Player(4000, "Caius Cosades"),
            null
    };


    static Stream<Arguments> players() {
        return Stream.of(
                Arguments.of(players, 200, -1),
                Arguments.of(players, 0, -1),
                Arguments.of(players, 900, -1),
                Arguments.of(players, 5000, -1),
                Arguments.of(players, 1600, 4),
                Arguments.of(players, 3000, 5),
                Arguments.of(players, 4000, 6),
                Arguments.of(players, 1100, 0)
        );
    }

    @DisplayName("find Players")
    @ParameterizedTest
    @MethodSource("players")
    void findPlayerTest(Doka3.Player[] players, int rating, int expected) {
        int actual = Doka4.searchRightmostPlayerWithRating(players, rating);
        assertEquals(expected, actual,
                "Most right player has index = " + expected + ", you answer is "
                        + actual + "\nPlayers:" + Arrays.toString(players));
    }

    static Doka3.Player[] expectedInsert = new Doka3.Player[]{
            new Doka3.Player(1100, "Crowbar Freeman"),
            new Doka3.Player(1200, "London Mollarik"),
            new Doka3.Player(1600, "Raziel of Kain"),
            new Doka3.Player(1600, "Gwinter of Rivia"),
            new Doka3.Player(1600, "Slayer of Fate"),
            new Doka3.Player(1600, "Shmike"),
            new Doka3.Player(3000, "Jon Know"),
            new Doka3.Player(4000, "Caius Cosades")
    };


    static Stream<Arguments> playersForInsert() {
        return Stream.of(Arguments.of(players, new Doka3.Player(1600, "Shmike"), 4, expectedInsert));
    }


    @DisplayName("insert Players")
    @ParameterizedTest
    @MethodSource("playersForInsert")
    void insertPlayer(Doka3.Player[] players, Doka3.Player newPlayer, int index, Doka3.Player[] expectedPlayers) {
        Doka3.Player[] actualPlayers = Doka4.insertPlayerInQueueWithShift(players, index, newPlayer);
        assertArrayEquals(expectedPlayers, actualPlayers);
    }
}