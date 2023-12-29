public class Game {
    private int level;
    private int mark;

    private Player player;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    @Override
    public String toString() {
        return "Game{" +
            "level=" + level +
            ", mark=" + mark +
            '}';
    }
}
