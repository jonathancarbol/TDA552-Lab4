import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawCar {

    private BufferedImage image;
    private Point point;
    private String name;

    public DrawCar(BufferedImage image, Point point, String name) {
        this.image = image;
        this.point = point;
        this.name = name;
    }

    BufferedImage getImage() {
        return image;
    }

    void setB(BufferedImage image) {
        this.image = image;
    }

    Point getPoint() {
        return point;
    }

    void setPoint(Point point) {
        this.point = point;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
