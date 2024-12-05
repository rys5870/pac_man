public class PlayerData {
    private String playerName;
    private int level;
    private int score;
    private int lives;
    private int point;

    public PlayerData(String playerName, int level, int score, int lives,int point) {
        this.playerName = playerName;
        this.level = level;
        this.score = score;
        this.lives = lives;
    }

    // גטרים וסטרים
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "PlayerData{" +
                "playerName='" + playerName + '\'' +
                ", level=" + level +
                ", Point=" + point +
                ", score=" + score +
                ", lives=" + lives +
                '}';
    }

}
