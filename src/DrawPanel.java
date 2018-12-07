import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private List<DrawCar> drawCars = new ArrayList<>();
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;

    void addList(){
        DrawCar Volvo240 = new DrawCar(volvoImage, new Point(), "Model.Volvo240");
        DrawCar Saab95 = new DrawCar(saabImage, new Point(),"Model.Saab95");
        DrawCar Scania = new DrawCar(scaniaImage, new Point(),"ScaniaGSleeper");
        drawCars.add(Volvo240);
        drawCars.add(Saab95);
        drawCars.add(Scania);
    }
    // TODO: Make this genereal for all cars
    void moveit(int x, int y, String modelName){
        for (int i = 0; i < drawCars.size(); i++){
            if (modelName.equals(drawCars.get(i).getName())){
                drawCars.get(i).getPoint().x = x;
                drawCars.get(i).getPoint().y = y;
            }
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        addList();

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offset = 0;

        for (int i = 0; i < drawCars.size(); i++){
            g.drawImage(drawCars.get(i).getImage(),drawCars.get(i).getPoint().x,drawCars.get(i).getPoint().y+offset,null);
            offset = offset+100;
        }
    }
}