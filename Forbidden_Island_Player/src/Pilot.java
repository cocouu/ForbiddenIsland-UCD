public class Pilot extends Player {
    public Pilot(Tile startPosition) {
        super(startPosition);
    }

    @Override
    public boolean moveTo(Tile target) {
        if (!target.isSunk()) {
            this.position = target;
            actionPoints--;
            return true;
        }
        return false;
    }
}
