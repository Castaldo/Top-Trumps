package commandline;
import java.sql.*;
import java.util.HashMap;

public class Database {

    public Database() {
    }


    private Connection c = null;

    public void DB() {

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "postgres");

        } catch (Exception e) {

            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }

    }

    public void updateLastGameStats(TTModel m) throws SQLException {


        String query = "INSERT INTO Last_Game_Stats(rounds_in_game,player_3_round_wins,player_5_round_wins,player_4_round_wins," +
                "player_2_round_wins,player_1_round_wins,num_of_draws,last_round_winner,game_winner,computer_wins) VALUES (?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement stmt = c.prepareStatement(query);
        stmt.setInt(1,m.getRoundsInGame());
        stmt.setInt(2,m.get3rounds());
        stmt.setInt(3,m.get5rounds());
        stmt.setInt(4,m.get4rounds());
        stmt.setInt(5,m.get2rounds());
        stmt.setInt(6,m.get1rounds());
        stmt.setInt(7,m.getNumOfDraws());
        stmt.setInt(8,m.getLastRoundWinner(m.getActivePlayers()));
        stmt.setInt(9,m.getWinner());
        stmt.setInt(10,m.getComputerwins());

        stmt.executeUpdate();

        System.out.print("Logged");

    }

    public HashMap<String, Integer> getLastGameStats() throws SQLException {

        Statement stmt;

        HashMap<String, Integer> stats = new HashMap<>();

        String query = "SELECT (rounds_in_game), (player_3_round_wins), (player_5_round_wins), (player_4_round_wins), " +
                "(player_2_round_wins), (player_1_round_wins), (num_of_draws), (last_round_winner), (game_winner), (computer_wins)" +
                " FROM last_game_stats;";

        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int rounds_in_game = rs.getInt("rounds_in_game");
                stats.put("Rounds in Game:  ", rounds_in_game);

                int player_3_round_wins = rs.getInt("player_3_round_wins");
                stats.put("Player three round wins: ",player_3_round_wins);

                int player_5_round_wins = rs.getInt("player_5_round_wins");
                stats.put("Player five round wins:  ",player_5_round_wins);

                int player_4_round_wins = rs.getInt("player_4_round_wins");
                stats.put("Player four round wins:  ",player_4_round_wins);

                int player_2_round_wins = rs.getInt("player_2_round_wins");
                stats.put("Player two round wins:  ",player_2_round_wins);

                int player_1_round_wins = rs.getInt("player_1_round_wins");
                stats.put("Player one round wins :  ",player_1_round_wins);

                int num_of_draws = rs.getInt("num_of_draws");
                stats.put("Number of Draws:  ", num_of_draws);

                int last_round_winner = rs.getInt("last_round_winner");
                stats.put("Last Round Winner is  ",last_round_winner);

                int game_winner = rs.getInt("game_winner");
                stats.put("Winner is  ",game_winner);

                int computer_wins = rs.getInt("computer_wins");
                stats.put("Total ",  computer_wins );



            }

        } catch (SQLException e) { //handle error
            e.printStackTrace();
            System.out.println("Error executing query.");

        }

        return stats;
    }

    public HashMap<String, Integer> getHistoricStats()  throws SQLException {

        Statement stmt;

        HashMap<String, Integer> PersistentStats = new HashMap<>();

        String query = "\n" +
                "SELECT \t (SELECT computer_wins\n" +
                "\t\t  FROM last_game_stats as aiWins),\n" +
                "\t\t (SELECT COUNT(*)\n" +
                "\t\t  FROM last_game_stats as gamesPlayed),\n" +
                "\t\t (SELECT AVG (num_of_draws)\n" +
                "\t\t  FROM last_game_stats) as draws,\n" +
                "\t\t (SELECT game_winner \n" +
                "\t\t  FROM last_game_stats\n" +
                "\t\t  WHERE game_winner = 1) as gameWinner,\n" +
                "\t\t  (SELECT MAX(rounds_in_game)\n" +
                "\t\t  FROM last_game_stats) as mostRoundsAll;";

        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                int aiWins = rs.getInt("computer_wins");
                PersistentStats.put("Total Number of Games is ", aiWins);

                int gamesPlayed = rs.getInt("gamesPlayed");
                PersistentStats.put("Number of Human Wins ", gamesPlayed);

                int num_of_draws = rs.getInt("num_of_draws");
                PersistentStats.put("Number of Computer Wins ", num_of_draws);

                int game_winner = rs.getInt("gameWinner");
                PersistentStats.put("Number of Human Wins ", game_winner);

                int mostRoundsAll = rs.getInt("rounds_in_game");
                PersistentStats.put("Number of Computer Wins ", mostRoundsAll);


            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error executing query.");

        }
        return PersistentStats;
    }
}