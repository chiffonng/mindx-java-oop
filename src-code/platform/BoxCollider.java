package game;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D anchor;

    public BoxCollider() {
        this(1, 1, 1, 1);
    }

    public BoxCollider(double x, double y, int width, int height) {
        position = new Vector2D(x, y);
        this.width = width;
        this.height = height;
        anchor = new Vector2D(0.5, 0.5);
    }

    public BoxCollider(GameObject object, int width, int height) {
        position = object.position;
        this.width = width;
        this.height = height;
        this.anchor = object.anchor;
    }

    public double top() {
        return position.y - anchor.y * height;
    }

    public double bot() {
        return top() + height;
    }

    public double left() {
        return position.x - anchor.x * width;
    }

    public double right() {
        return left() + width;
    }

    public boolean intersect(BoxCollider other) {
//        double left = this.position.x - (other.position.x + other.width);
//        double right = other.position.x - (this.position.x + this.width);
//        double top = other.position.y + other.height - this.position.y;
//        double bottom = this.position.y + this.height - other.position.y;
//        if (left < 0 && right < 0  && top > 0 && bottom > 0) { return false; }
        return this.right() >= other.left() && this.left() <= other.right() && this.top() <= other.bot() && this.bot() >= other.top();
    }

    public static void main(String[] args) {
        BoxCollider r1 = new BoxCollider(0, 0, 3, 3);
        BoxCollider r2 = new BoxCollider(1, 1, 3, 3);
        BoxCollider r3 = new BoxCollider(4, 4, 3, 3);

        System.out.println(r1.intersect(r2)); //true
        System.out.println(r1.intersect(r3)); //false
        System.out.println(r2.intersect(r3)); //true
    }
}
