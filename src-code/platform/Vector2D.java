package game;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector2D input) {
        input.x += x;
        input.y += y;
    }

    public void scale(double rate) {
        this.x *= rate;
        this.y *= rate;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D other) {
        this.set(other.x, other.y);
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public void setLength(double length) {
        double currentLength = this.getLength();
        if (currentLength != 0 && length >= 0) {
            this.x *= length / currentLength;
            this.y *= length / currentLength;
        }
    }

    public double distanceTo(Vector2D other) {
        //calculate distance between two points
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double getAngle() {
        return Math.toDegrees(Math.atan2(this.y, this.x));
    }

    public void setAngle(double angle) {
        double currentLength = this.getLength();
        if (currentLength != 0) {
            this.x = currentLength * Math.cos(angle);
            this.y = currentLength * Math.sin(angle);
        }
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1, 1);
        Vector2D v2 = new Vector2D(0, 0);
        System.out.println(v1.distanceTo(v2));
    }
}
