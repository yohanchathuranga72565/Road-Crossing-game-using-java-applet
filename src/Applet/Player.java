/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 *
 * @author Yohan
 */
public class Player implements KeyListener {
    private int x = 200;
    private int y = 350;
    private int radius = 20;
    private int velX = 0;
    private int velY = 0;
    private URL url;
    private Image player;
    
    public Player(MainClass mc){
        url = mc.getDocumentBase();
        player = mc.getImage(url, "images.png");
    }
    public void update(MainClass mc){
        mc.addKeyListener(this);
        x+=velX;
        y+=velY;
        
        if(y==0){
            System.out.println("You are won...");
        }
    }
    
    public void paint(Graphics g, MainClass mc){
//        g.fillOval(x, y, radius * 2, radius * 2);
//        g.setColor(Color.red);
//        g.fillRect(x, y, radius * 2, radius * 2);
        g.drawImage(player, x, y,40,40, mc);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:{
                velX = 5 ;
                break;
            }
            case KeyEvent.VK_LEFT:{
                velX = -5 ;
                break;
            }
            case KeyEvent.VK_UP:{
                velY = -5 ;
                break;
            }
            case KeyEvent.VK_DOWN:{
                velY = 5 ;
                break;
            }
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:{
                velX = 0 ;
                break;
            }
            case KeyEvent.VK_LEFT:{
                velX = 0 ;
                break;
            }
            case KeyEvent.VK_UP:{
                velY = 0 ;
                break;
            }
            case KeyEvent.VK_DOWN:{
                velY = 0 ;
                break;
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent arg0){
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void restart(){
        x = 200;
        y = 350;
    }
    
}
