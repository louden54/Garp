import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int random;
        
        move(5); // 5px vooruit
        if(atWorldEdge()) {
            move(-5);
            if(Greenfoot.getRandomNumber(100)<50){
                setRotation(getRotation() +Greenfoot.getRandomNumber(180));
            }
            else{
                setRotation ( getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        else {
            random = Greenfoot.getRandomNumber(100);
            if(random < 2){
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            if(random > 98 ) {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        lookForGarp();
        lookForActor();
    }
    protected void lookForActor() {
    Actor actor;
    actor = getOneObjectAtOffset(0,0,Actor.class);
    if((actor != null))
        turn(45);
    }
    protected void lookForGarp() {
    Actor garp;
    garp = getOneObjectAtOffset(1,1, Garp.class);
    if((garp != null)){
        Greenfoot.playSound("scream.mp3");
        getWorld().removeObject(garp);
        Greenfoot.stop();
    }
}
    public boolean atWorldEdge() {
        int x , i , y , wx , wy;
        
        x = getX();
        i = getImage().getWidth() / 2;
        if(x <= i) {
            return true;
        }
         y = getY();
        if(y <= i) {
            return true;
        }
         wx = getWorld().getWidth() - i;
        
        if(x >= wx) {
            return true;
        }
        wy = getWorld().getHeight() -i;
        if( x >= wy) {
            return true;
        }
        return false;
    }

}

