public class Navigator extends Player {
    public Navigator(Tile startPosition) {
        super(startPosition);
    }
    //导航技能
    public void navigation(Player Player_1, Tile targetTile_1, Player Player_2, Tile targetTile_2) {
        if (Player_1 != this && Player_2 != this) {
            if (Player_1.canMove(targetTile_1) && Player_2.canMove(targetTile_2)) {
                Player_1.moveTo(targetTile_1);
                Player_2.moveTo(targetTile_2);
                actionPoints--;
            }
        }
    }
}
