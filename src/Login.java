import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private static final String FILE_NAME = "players.json";
    public static List<PlayerData> players = loadPlayers();

    private static void savePlayers(List<PlayerData> players) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(players, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static java.util.List<PlayerData> loadPlayers() {
        Gson gson = new Gson();
        java.lang.reflect.Type playerListType = new TypeToken<List<PlayerData>>() {
        }.getType();


        try (FileReader reader = new FileReader("players.json")) {
            players = gson.fromJson(reader, playerListType);
            if (players == null) {
                players = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error reading file, creating a new one.");
        }

        return players;
    }

    public static void addPleyer(PlayerData newPlayer) {
        boolean userExists = false;
        for (PlayerData player : players) {
            if (player.getPlayerName().equals(newPlayer.getPlayerName())) {
                player.setLevel(newPlayer.getLevel());
                player.setScore(newPlayer.getScore());
                player.setLives(newPlayer.getLives());
                player.setPoint(newPlayer.getPoint());
                userExists = true;
                break;
            }
        }

        // אם המשתמש לא קיים, נוסיף אותו לרשימה
        if (!userExists) {
            players.add(newPlayer);
        }
        savePlayers(players);

    }

}
