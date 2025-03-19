public class Engineer extends Player {
    public Engineer(Tile startPosition) {
        super(startPosition);
    }
    //抽水两次
    public void shoreUp(Tile target_1 , Tile target_2) {
        if (this.canShore(target_1) && this.canShore(target_2)) {
            target_1.restore();
            target_2.restore();
            actionPoints--;
        }
    }
}
