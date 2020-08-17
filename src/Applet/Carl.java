/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

/**
 *
 * @author Yohan
 */
public class Carl {
    private int x;
    private int y;
    private int speed;
    private URL url;
    private Image car;
    
    public Carl(MainClass mc, int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        url = mc.getDocumentBase();
        car = mc.getImage(url, "carl.png");
    }

    
    public void update(MainClass mc, Player p){
        x+=speed;
        if(x==400){
            x=0;
        }
        collision(p);
    }
    
    private void collision(Player p){
        int PX = p.getX();
        int PY = p.getY();
        if(!(PX==200 && PY==350)){
            if((y >= PY-50 && y <= PY+50) && (x <= PX + 50 && x >= PX - 50)){
            p.restart();
            System.out.println("Collision detected");
            }
        }
        
    }
    
    public void paint(Graphics g, MainClass mc){
//        g.fillOval(x, y, radius * 2, radius * 2);
//        g.setColor(Color.red);
//        g.fillRect(x, y, radius * 2, radius * 2);
//        g.drawImage(car, x, y, mc);
        g.drawImage(car, x, y, 50, 25, mc);
    }
}
