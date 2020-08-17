/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet;
import java.applet.*;
import java.awt.*;
/**
 *
 * @author Yohan
 */
public class MainClass extends Applet implements Runnable {
    Thread thread = new Thread(this);
    boolean running = true;
    Player p;
    Car cr1;
    Car cr2;
    Car cr3;
    Carl cl1;
    Carl cl2;
    Carl cl3;
    Image dbImage;
    Graphics dbg;
    public void init(){
        setSize(400,500);
        p = new Player(this);
        cr1 = new Car(this, 0 ,50 ,5);
        cr2 = new Car(this, 50 ,100, 2);
        cr3 = new Car(this, 150 ,150, 2);
        cl1 = new Carl(this, 150 ,200, 2);
        cl2 = new Carl(this, 50 ,250, 2);
        cl3 = new Carl(this, 300 ,300, 5);
        
    }
    
    public void start(){
        thread.start();
    }
    
    public void destroy(){
        running = false;
    }
    
    public void stop(){
        running = false;
    }
    
    public void run(){
        while(running){
            repaint();
            p.update(this);
            cr1.update(this, p);
            cl1.update(this,p);
            cl2.update(this,p);
            cr2.update(this, p);
            cl3.update(this,p);
            cr3.update(this, p);
            try{
                Thread.sleep(20);
            }
            catch(InterruptedException e){
                System.out.println("Error Has Ocuured");
            }
        }
    }
    
    public void update(Graphics g){
        dbImage = createImage(400, 400);
        dbg = dbImage.getGraphics();
        paint(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public void paint(Graphics g){
        p.paint(g, this);
        cr1.paint(g, this);
        cl1.paint(g, this);
        cl2.paint(g, this);
        cr2.paint(g, this);
        cl3.paint(g, this);
        cr3.paint(g, this);
        g.drawString("Cross the road using arrow keys...", 10, 450);
        int PY=p.getY();
        if(PY == 0){
           g.drawString("You are won...", 10, 490); 
        }
    }
    
}
