package game;

import Enemy.Enemy;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //Object Management
    public static ArrayList<GameObject> listObjects = new ArrayList<>();

    public static void runAll() {
        for (int i = 0; i < listObjects.size(); i++) {
            GameObject object = listObjects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < listObjects.size(); i++) {
            GameObject object = listObjects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }

    public static Enemy findEnemyIntersect(GameObject collider) {
        for (int i = 0; i < listObjects.size(); i++) {
            GameObject object = listObjects.get(i);
            if (object.active && object instanceof Enemy && object.hitBox != null && object.hitBox.intersect(collider.hitBox)) {
                return (Enemy) object; //convert object from GameObject to Enemy
            }
        }
        return null;
    }

    //Class Type: E ~ Player | Enemy | PlayerBullet
    //Class Class:
    public static <E> E findIntersection(Class<E> cls, GameObject collider) {
        for (int i = 0; i < listObjects.size(); i++) {
            GameObject object = listObjects.get(i);
            if (object.active && cls.isAssignableFrom(object.getClass()) && object.hitBox != null && object.hitBox.intersect(collider.hitBox)) {
                return (E) object;
            }
        }
        return null;
    }
    public static void clear(){
        listObjects.clear();
    }
    //Object Definition
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public BoxCollider hitBox;
    public Vector2D anchor;
    public final double GRAVITY = 0.5;

    public GameObject() {
        listObjects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        active = true;
        anchor = new Vector2D(0.5, 0.5);
    }

    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, this);
        }
        ;
    }

    public void run() {
        position.add(velocity);
    }
    public void GravityPull() {
        this.velocity.add(0, GRAVITY);
        this.position.add(velocity);
    }


    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }

}

