public class Massenger extends Player{
    public Massenger(Tile startPosition) {
        super(startPosition);
    }
    //无视地形递卡
    @Override
    protected boolean canSend(Player player) {
        return player != this; // 只要不是自己，Messenger 可以传递卡牌
    }
}
