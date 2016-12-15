import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
/**
 * Write a description of class EndScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScore extends Score
{
    private long startTime;
   
    
    public EndScore(){
        startTime = System.currentTimeMillis();
    }
    
    public String getElapsedTime(){
        long duration;
        int uren, minuten, seconden;
        String duur;
        
        duration = System.currentTimeMillis() - startTime;
        seconden = (int)(duration / 1000);
        uren = seconden / 3600;
        seconden %= 3600;
        minuten = (int)(seconden/60);
        seconden %= 60;
        duur = String.format("Duur: %02d:%02d", uren , minuten , seconden);
        return duur;
    }
    
    public void setEndImage(int score) {
        GreenfootImage image;
        String tekst , resultaat;
        Dimension dim;
        
        if(score == 10 )
            resultaat = "Je hebt gewonnen..!";
        else
            resultaat = "Je hebt verloren..!";
       tekst = getElapsedTime();
       tekst += "\n\r" + "aantal diamanten:" + score + "\n\r" + resultaat;
       image = new GreenfootImage(10,10);
       
       
       Font font = new Font ("Calibri" , Font.BOLD , 20);
       image.setFont(font);
       
       
       dim = getTextDimensions(image,tekst);
       dim.height *=4;
       dim.width /= 2;
       image.scale(dim.width, dim.height);
       
       image.setColor(new Color(255,255,255,128));
       image.fillRect(0,0,dim.width,dim.height);
       image.setColor(new Color(128,128,128,128));
       image.fillRect(0,4,4,dim.height);
       image.fillRect(4, dim.height = 4 , dim.width = 8 , dim.height - 4);
       
       setImage(image);
       image.setColor(new Color(100,100,255));
       image.drawString(tekst,dim.width / 8,20);
     }
    /**
     *
     * Act - do whatever the EndScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
