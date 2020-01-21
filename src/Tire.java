public class Tire {
    private int radius = 0;
    private int rotate = 0;
    private int distance = 0;
    Tire(int radius) {
        this.radius = radius;
    }

    void Rotate(int degree) {
        this.rotate = (this.rotate + degree) % 360;
    }
}
