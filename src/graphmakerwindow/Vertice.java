  package graphmakerwindow;
import javafx.scene.shape.Circle;
import java.util.HashMap;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Point2D;
/**
 *
 * Graph vertex class
 *
 * @version 1.0 vom 01.05.2019
 * @author Axel Schorcht -119650
 */

public class Vertice extends Circle {
  
  // Beginn attributes
  String name="Default";
  int number;
  HashMap<String, String> attributes = new HashMap<String, String>();
  Vector layoutVar=new Vector(0,0);   //imported for forcedirected drawing
  // End attributes
  
  public Vertice(int number) {
    this.number=number;
  }
  public Vertice(int number, String name) {
    this.number=number;
    this.name=name;
  }

  // Anfang Methoden
 
  // Ende Methoden
} // end of Vertice

