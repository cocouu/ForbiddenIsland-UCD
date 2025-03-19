public class Explorer extends Player {
    public Explorer(Tile startPosition) {
        super(startPosition);
    }

    //可倾斜移动和抽水
    @Override
    public boolean canMove(Tile target) {
        return !target.isSunk() && (this.position.isAdjacent(target) || this.position.isDiagonal(target));
    }

    @Override
    public boolean canShore(Tile target) {
        return target.isSunk() && (this.position.isAdjacent(target) || this.position.isDiagonal(target));
    }
}
