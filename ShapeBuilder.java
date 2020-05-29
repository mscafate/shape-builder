
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class ShapeBuilder {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static int shapeCount;
    private static String color;
    private static boolean shapeFill;
    
    public abstract class Shape extends Rectangle {
        
        //Shape class instance variables
        private String color;
        private boolean shapeFill;
        
        //Shape constructor 
        public Shape(Rectangle rect, String color, boolean shapeFill){
            shapeCount++;
            this.color = color;
            this.shapeFill = shapeFill;
        }
        
        public void setColor(Graphics g) {
             
        }
        public boolean getSolid() {
            return shapeFill;
        }
        public int getNumShapes() {
        return shapeCount;
        }
        public void draw(Graphics g) {
            
        }

}
     public class Oval {
        private String color;
        private boolean shapeFill;
        
         public Oval(Rectangle rect, String color, boolean shapeFill) {
            shapeCount++;
            this.color = color;
            this.shapeFill = shapeFill;
            
         }
         public void draw(Graphics g) {
                 
             }
     }
     
     public class Rectangular {
         private String color;
        private boolean shapeFill;
        
         public Rectangular(Rectangle rect, String color, boolean shapeFill) {
            shapeCount++;
            this.color = color;
            this.shapeFill = shapeFill;
            
         }
         public void draw(Graphics g) {
                 
             }
     }

     
     
     
     
     
     
     
     
     
     

        public static class Drawing extends JPanel {
           String[] shapeTypeList = {"Rectangle", "Oval"};
           String[] colorTypeList = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"};
           String[] fillTypeList = {"Solid", "Hollow"};
           private int width;
           private int height;
           private String shapeType = " ";
           private String fillType = " ";
           private String color = " ";
           private int x = 0;
           private int y = 0;
           
           private JLabel shapeTypeL = new JLabel("Shape Type");
           private JLabel fillTypeL = new JLabel("Fill Type");
           private JLabel colorL = new JLabel("Color");
           private JLabel widthL = new JLabel("Width");
           private JLabel heightL = new JLabel("Height");
           private JLabel xCoordinateL = new JLabel("x coordinate");
           private JLabel yCoordinateL = new JLabel("y coordinate");
           
           private JComboBox shapeTypeCB = new JComboBox(shapeTypeList);
           private JComboBox fillTypeCB = new JComboBox(fillTypeList);
           private JComboBox colorCB = new JComboBox(colorTypeList);
           private JTextField widthTF = new JTextField(12);
           private JTextField heightTF = new JTextField(12);
           private JTextField xCoordinateTF = new JTextField(12);
           private JTextField yCoordinateTF = new JTextField(12);
           
           private JButton drawB = new JButton("Draw");
           
           public Drawing(){
               setLayout(null);
               
               drawB.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){

                 shapeType = shapeTypeCB.getSelectedItem().toString();
                 fillType = fillTypeCB.getSelectedItem().toString();
                 color = colorCB.getSelectedItem().toString();
                 width = Integer.parseInt(widthTF.getText());
                 height = Integer.parseInt(heightTF.getText());
                 x = Integer.parseInt(xCoordinateTF.getText());
                 y = Integer.parseInt(yCoordinateTF.getText());
                 repaint();
                 
             }
         });
                
                shapeTypeL.setBounds(10, 10, 100, 20);
                fillTypeL.setBounds(10, 40, 100, 20);
                colorL.setBounds(10, 70, 100, 20);
                widthL.setBounds(10, 100, 100, 20);
                heightL.setBounds(10, 130, 100, 20);
                xCoordinateL.setBounds(10, 160, 100, 20);
                yCoordinateL.setBounds(10, 190, 100, 20);
                
                shapeTypeCB.setSelectedIndex(1);
                fillTypeCB.setSelectedIndex(1);
                colorCB.setSelectedIndex(6);
                
                shapeTypeCB.setBounds(100, 10, 120, 20);
                fillTypeCB.setBounds(100, 40, 100, 20);
                colorCB.setBounds(100, 70, 100, 20); 
                
                
                widthTF.setBounds(100, 100, 100, 20);
                heightTF.setBounds(100, 130, 100, 20);
                xCoordinateTF.setBounds(100, 160, 100, 20);
                yCoordinateTF.setBounds(100, 190, 100, 20);
                
                
                drawB.setBounds(50, 230, 100, 20);
                
                add(shapeTypeL);
                add(fillTypeL);
                add(colorL);
                add(widthL);
                add(heightL);
                add(xCoordinateL);
                add(yCoordinateL);
                
                add(shapeTypeCB);
                add(fillTypeCB);
                add(colorCB);
                
                add(widthTF);
                add(heightTF);
                add(xCoordinateTF);
                add(yCoordinateTF);
                
                add(drawB);
                

           }
         public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(color == "Black"){
                g.setColor(Color.BLACK);
            }
            else if(color == "Red") {
                g.setColor(Color.RED);
            }
            else if(color == "Orange") {
                g.setColor(Color.ORANGE);
            }
            else if(color == "Yellow") {
                g.setColor(Color.YELLOW);
            }
            else if(color == "Green") {
                g.setColor(Color.GREEN);
            }
            else if(color == "BLUE") {
                g.setColor(Color.BLUE);
            }
            else if(color == "Magenta") {
                g.setColor(Color.MAGENTA);
            }
            if (shapeType == "Rectangle") {
                if(fillType == "Solid") {
                    g.fillRect(x, y, width, height);
                }
                else if(fillType == "Hollow") {
                     g.drawRect(x, y, width, height);
                }
            }
            if (shapeType == "Oval"){
                if(fillType == "Solid") {
                    g.fillOval(x, y, width, height);
                }
                else if(fillType == "Hollow") {
                    g.drawOval(x, y, width, height);
                }
            }

         
         }



         
         
         public void getPreferredSize(int hight, int width) {
             
         }
         public void drawShape() {
             
         }

        
      }//end Drawing
 
     
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Geometric Drawing");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        frame.setSize(600, 400);
        frame.add(new Drawing());
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
 
     
}



