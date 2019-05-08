package graphmakertool;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Tooltip;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.HashMap;
import javafx.geometry.Point2D;
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 01.05.2019
 * @author Axel Schorcht - 119650  
 */

public class Graph {
  
  // Anfang Attribute
  ArrayList<Vertice> verticles = new ArrayList<Vertice>();
  ArrayList<Edge> edges = new ArrayList<Edge>();
  // Ende Attribute
  
  public Graph() {
  }
  
  
  // Anfang Methoden
  public void addVert(int number){
    
    Vertice v=new Vertice(number);
    v.setCenterX(40+new Random().nextInt(700));
    v.setCenterY(40+new Random().nextInt(450));
    v.setRadius(40);
    while (checkVerticeIntersection(v)||checkVertLineIntersection(v)) { 
      v.setCenterX(40+new Random().nextInt(800));
      v.setCenterY(40+new Random().nextInt(650));
    } // end of while
    v.setRadius(20);
    v.setFill(Color.WHITE);
    v.setStroke(Color.BLACK);
    v.setStrokeWidth(3);
    v.toFront();
    
    verticles.add(v);
    
  }
  public void addVert(int number,int[] connections){
    Vertice v=new Vertice(number);
    v.setCenterX(40+new Random().nextInt(800));
    v.setCenterY(40+new Random().nextInt(650));
    v.setRadius(80);
    while (checkVerticeIntersection(v) ||checkVertLineIntersection(v)) { 
      v.setCenterX(40+new Random().nextInt(800));
      v.setCenterY(40+new Random().nextInt(650));
    } // end of while   
    v.setFill(Color.WHITE);
    v.setStroke(Color.BLACK);
    v.setStrokeWidth(3);
    v.setRadius(20);
    
    
    ArrayList<Edge> currentEdges = new ArrayList<Edge>();
    for (int i:connections ) {
      
      Edge l = new Edge();
      Vertice end=v;
      for (Vertice v2 : verticles) {
        if(v2.number==i) {
          l.startXProperty().bind(v.centerXProperty());
          l.startYProperty().bind(v.centerYProperty());
          
          l.endXProperty().bind(v2.centerXProperty());
          l.endYProperty().bind(v2.centerYProperty());
          end=v2;
          break;
        }
        
      } // end of for
      
      for (Vertice ver:verticles ){
        if (checkLineVertIntersection(l,ver,end)) { 
          this.addVert(number,connections);
          return;
        } // end of if 
      }
      
      
      currentEdges.add(l);
    } // end of for    
    for (Edge e:currentEdges) {
      edges.add(e);
      
    } // end of for
    v.toFront();
    verticles.add(v);
    
  }              
  
  public void addVert(int number, String name){
    
    Vertice v=new Vertice(number,name);
    v.setCenterX(40+new Random().nextInt(800));
    v.setCenterY(40+new Random().nextInt(650));
    v.setRadius(40);
    while (checkVerticeIntersection(v)||checkVertLineIntersection(v)) { 
      v.setCenterX(40+new Random().nextInt(800));
      v.setCenterY(40+new Random().nextInt(650));
    } // end of while
    v.setRadius(20);
    v.setFill(Color.WHITE);
    v.setStroke(Color.BLACK);
    v.setStrokeWidth(3);
    v.toFront();
    
    verticles.add(v);
    
  }
  public void addVert(int number,int[] connections, String name){
    Vertice v=new Vertice(number, name);
    if(!verticles.isEmpty()){
      
    v.setCenterX(40+new Random().nextInt(800));
      }
    else {
      v.setCenterX(40+new Random().nextInt(800));
    } // end of if-else
    v.setCenterY(40);//+new Random().nextInt(650));
    v.setRadius(40);
    while (checkVerticeIntersection(v) ||checkVertLineIntersection(v)) { 
      v.setCenterX(40+new Random().nextInt(800));
      v.setCenterY(40+new Random().nextInt(650));
    } // end of while   
    v.setFill(Color.WHITE);
    v.setStroke(Color.BLACK);
    v.setStrokeWidth(3);
    v.setRadius(20);
    
    
    ArrayList<Edge> currentEdges = new ArrayList<Edge>();
    for (int i:connections ) {
      
      Edge l = new Edge();
      Vertice end=v;
      for (Vertice v2 : verticles) {
        if(v2.number==i) {
          l.startXProperty().bind(v.centerXProperty());
          l.startYProperty().bind(v.centerYProperty());
          
          l.endXProperty().bind(v2.centerXProperty());
          l.endYProperty().bind(v2.centerYProperty());
          end=v2;
          break;
        }
        
      } // end of for
      
      for (Vertice ver:verticles ){
        if (checkLineVertIntersection(l,ver,end)) { 
          this.addVert(number,connections,name);
          return;
        } // end of if 
      }
      
      
      currentEdges.add(l);
    } // end of for    
    for (Edge e:currentEdges) {
      edges.add(e);
      
    } // end of for
    v.toFront();
    verticles.add(v);
    
  }
  
  public void addVert(int number, String name, String attr){
    
    Vertice v=new Vertice(number,name);
    v.setCenterX(40+new Random().nextInt(800));
    v.setCenterY(40+new Random().nextInt(650));
    v.setRadius(40);
    while (checkVerticeIntersection(v)||checkVertLineIntersection(v)) { 
      v.setCenterX(40+new Random().nextInt(800));
      v.setCenterY(40+new Random().nextInt(650));
    } // end of while
    v.setRadius(20);
    v.setFill(Color.WHITE);
    v.setStroke(Color.BLACK);
    v.setStrokeWidth(3);
    v.toFront();
    for (String s:attr.split(",")) {
      String[] pair=s.split(":");
      v.attributes.put(pair[0],pair[1]);
    } // end of for
    verticles.add(v);
    
  }
  public void addVert(int number,int[] connections, String name, String attr){
    Vertice v=new Vertice(number, name);
    v.setCenterX(40+new Random().nextInt(800));
    v.setCenterY(40+new Random().nextInt(650));
    v.setRadius(40);
    while (checkVerticeIntersection(v) ||checkVertLineIntersection(v)) { 
      v.setCenterX(40+new Random().nextInt(800));
      v.setCenterY(40+new Random().nextInt(650));
    } // end of while   
    v.setFill(Color.WHITE);
    v.setStroke(Color.BLACK);
    v.setStrokeWidth(3);
    v.setRadius(20);
    
    
    ArrayList<Edge> currentEdges = new ArrayList<Edge>();
    if(connections.length!=0&&connections!=null){
      
      for (int i:connections ) {
        
        Edge l = new Edge();
        Vertice end=v;
        for (Vertice v2 : verticles) {
          if(v2.number==i) {
            l.startXProperty().bind(v.centerXProperty());
            l.startYProperty().bind(v.centerYProperty());
            
            l.endXProperty().bind(v2.centerXProperty());
            l.endYProperty().bind(v2.centerYProperty());
            end=v2;
            break;
          }
          
        } // end of for
        
        for (Vertice ver:verticles ){
          if (checkLineVertIntersection(l,ver,end)) { 
            this.addVert(number,connections);
            return;
          } // end of if 
        }
        
        
        currentEdges.add(l);
      } // end of for 
    }   
    if(attr!=null&&attr.length()>0){
      
      for (String s:attr.split(",")) {
        String[] pair=s.split(":");
        v.attributes.put(pair[0],pair[1]);
      } // end of for
    }
    for (Edge e:currentEdges) {
      edges.add(e);
      
    } // end of for
    v.toFront();
    verticles.add(v);
    
  }
  
  private boolean checkVerticeIntersection(Vertice vert) {
    for (Vertice static_bloc : verticles) {
      if (static_bloc != vert) {
        Shape intersect = Vertice.intersect(vert, static_bloc);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          return true;
        }
      }
    }
    return false;
  }                       
  
  private boolean checkVertLineIntersection(Vertice vert) {
    for (Shape static_bloc : edges) {
      if (static_bloc != vert) {
        Shape intersect = Vertice.intersect(vert, static_bloc);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean checkLineVertIntersection(Edge edge, Vertice vert, Vertice v) {
    for (Shape static_bloc : verticles) {
      if (static_bloc != edge&&vert!=static_bloc&&v!=static_bloc) {
        Shape intersect = Vertice.intersect(edge, static_bloc);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void removeVertice(Vertice v){
    ArrayList<Edge> edgesToDelete=new ArrayList<Edge>();
    for (Shape static_bloc : edges) {
      if (static_bloc != v) {
        Shape intersect = Vertice.intersect(v, static_bloc);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          edgesToDelete.add((Edge)static_bloc);
        }
      }
    }
    edges.removeAll(edgesToDelete);
    verticles.remove(v);
    
  }
  
  public void forceDirectedGraphDrawing(){
    double relaxation=0.0378;
    double accuracy=0.01;
    
    for (int count=0; count<=100;count++ ) {
      Vector sumForce=new Vector();
      Vector tmpForce=new Vector();
      double maxForce=0;
      for (Vertice v:verticles) {
        v.layoutVar=new Vector();
      } // end of for
      for (Vertice n:verticles) {
        for (Vertice m:verticles) {
          if (n!=m) {
            sumForce=computeForce(n,m);
            
            for (Edge e : edges) {
              Edge ed=new Edge();
              Vector v1=new Vector(n.getCenterX(),n.getCenterY());
              Vector v2=new Vector(m.getCenterX(),m.getCenterY());
              Vector l1=new Vector(e.getStartX(),e.getStartY());
              Vector l2=new Vector(e.getEndX(),e.getEndY());
              if ((v1.equals(l1)||v1.equals(l2))&&(v2.equals(l1)||v2.equals(l2))) {
                if(v1.equals(l1)){
                  tmpForce = computeForce(n,m,e);
                  sumForce = sumForce.add(tmpForce);
                  }
                if(v2.equals(l1)){
                  tmpForce = computeForce(n,m,e);
                  sumForce = sumForce.sub(tmpForce);
                  }
                tmpForce = computeForce(n,m,e);
                sumForce = sumForce.add(tmpForce);
                break;
              } // end of if
              
            }
            n.layoutVar=n.layoutVar.sub(sumForce);
            m.layoutVar=m.layoutVar.add(sumForce);
          } // end of if
        } // end of for
        
        n.setCenterX(n.getCenterX()+relaxation*n.layoutVar.getX());
        n.setCenterY(n.getCenterY()+relaxation*n.layoutVar.getY());
        
      } // end of for
      
    } // end of for
    centerLayout();
  }
  
  private Vector computeForce(Vertice s, Vertice t){
    double repulsion=2000;
    Vector force=new Vector(t.getCenterX(),t.getCenterY()).sub(new Vector(s.getCenterX(),s.getCenterY()));
    double d=Math.sqrt(Math.pow(force.getX(),2)+Math.pow(force.getY(),2));
    
    force=(force.Mul(repulsion)).Div(Math.pow(d,3));
    return force;
   

  }
  
  private Vector computeForce(Vertice s, Vertice t,Edge e){
    double attraction=200;
    Vector force=new Vector(t.getCenterX(),t.getCenterY()).sub(new Vector(s.getCenterX(),s.getCenterY()));
    double d=Math.sqrt(Math.pow(force.getX(),2)+Math.pow(force.getY(),2));
    force=(force.Mul(attraction-d)).Div(d);
    return force;
    
  }
  
  private void centerLayout(){
    double x = 0;
    double y = 0;
    for (Vertice v:verticles) {
      if(v.getCenterX()>x)
      x=v.getCenterX();
        
      if(v.getCenterY()>y)
      y=v.getCenterY();
    } // end of for
    for (Vertice v:verticles) {   
      v.setCenterX(v.getCenterX()-x+500);
      v.setCenterY(v.getCenterY()-y+500);
    } // end of for
    
  }
  
  public void orderCircleWise(){
    int layerCount=2;
    double layerDistance=100;
    double nodeDistance=300;
    double maximumHeight=50;
    int numberOfNotesPerLayer=verticles.size()/layerCount;
    if (verticles.size()%layerCount!=0) {
      numberOfNotesPerLayer+=1;
    } // end of if
    double r=numberOfNotesPerLayer*maximumHeight/Math.PI;
    double phi=2*Math.PI/numberOfNotesPerLayer;
    int currentNodeNumber=0;
    for (Vertice v:verticles) {
      currentNodeNumber+=1;
      if (layerCount>1 && currentNodeNumber%(numberOfNotesPerLayer+1)==0) {
        r=r+layerDistance;
        currentNodeNumber=0;
      } // end of if
      v.setCenterX(r*Math.cos((currentNodeNumber-1)*phi)+450);
      v.setCenterY(r*Math.sin((currentNodeNumber-1)*phi)+400);
    } // end of for
  }
      // Ende Methoden
} // end of Graph
      
