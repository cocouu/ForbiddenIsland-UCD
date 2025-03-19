public class Diver extends Player {
    public Diver(Tile startPosition) {
        super(startPosition);
    }
    //潜水逻辑（待完善
    @Override
    public boolean canMove(Tile target){
        return false;
    }
}
