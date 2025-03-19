import java.util.ArrayList;
import java.util.List;

public class Player {
    protected Tile position; // 当前位置
    protected int actionPoints;
    protected List<TreasureCard> treasureCards;

    public Player(Tile tile) {
        this.position = tile;
        this.treasureCards = new ArrayList<>();
    }
    public Tile getPosition() {
        return position;
    }
    public int getActionPoints() {
        return actionPoints;
    }
    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    public List<TreasureCard> getTreasureCards() {
        return new ArrayList<>(treasureCards);
    }

    //检查是否可移动
    protected boolean canMove(Tile target) {
    return !target.isSunk() && this.position.isAdjacent(target);
    }
    //检查是否可抽水
    protected boolean canShore(Tile target) {
        return target.isSunk() && this.position.isAdjacent(target);
    }
    //检查是否可递卡
    protected boolean canSend(Player player) {
        return player != this && this.getPosition().equals(player.getPosition());
    }



    //移动
    protected void moveTo(Tile target) {
        if (this.canMove(target)) { // 不能移动到沉没的版块
            this.position = target;
            actionPoints--;
        }
    }
    // 抽水
    protected void shoreUp(Tile target) {
        if (this.canShore(target)) {
            target.restore();
            actionPoints--;
        }
    }
    //递送卡牌
    protected void send(TreasureCard card, Player recipient) {
        if (card!=null && this.canSend(recipient)) {
            this.treasureCards.remove(card);
            recipient.treasureCards.add(card);
            actionPoints--;
        }
    }
}
