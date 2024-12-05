import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class SaveData {

    private static final String FILE_NAME = "players.json";

    public static void main(String[] args) {
          List<PlayerData> players = loadPlayers();
        PlayerData newPlayer = new PlayerData("Charlie", 2, 150, 2,0);

        // בדיקת קיום המשתמש ועדכון נתונים
        boolean userExists = false;
        for (PlayerData player : players) {
            if (player.getPlayerName().equals(newPlayer.getPlayerName())) {
                player.setLevel(newPlayer.getLevel());
                player.setScore(newPlayer.getScore());
                player.setLives(newPlayer.getLives());
                userExists = true;
                break;
            }
        }

        // אם המשתמש לא קיים, נוסיף אותו לרשימה
        if (!userExists) {
            players.add(newPlayer);
        }

        // שמירת הרשימה המעודכנת לקובץ
        savePlayers(players);
    }

    private static List<PlayerData> loadPlayers() {
        Gson gson = new Gson();
        Type playerListType = new TypeToken<List<PlayerData>>() {}.getType();
        List<PlayerData> players = new ArrayList<>();

        try (FileReader reader = new FileReader(FILE_NAME)) {
            players = gson.fromJson(reader, playerListType);
            if (players == null) {
                players = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error reading file, creating a new one.");
        }

        return players;
    }

    private static void savePlayers(List<PlayerData> players) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(players, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

