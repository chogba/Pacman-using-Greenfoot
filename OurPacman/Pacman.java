    import greenfoot.*;

/**
 * Write a description of class Pacman here.
 * 
 * @author (ChorG) 
 * @version (21/8/2015)
 */
public class Pacman extends Actor
{
    public int score = 0;
    public Counter counter2;
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pacman(Counter counter)
    {
        counter2=counter;
        setImage("pacman_r.png");
    }
    
    public void act() 
    {
       move();
       collectCoin();
       eatenByGhost();
    }  
        
    
    
    public boolean canMove()
    {
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        if (x>=myWorld.getWidth() || y>=myWorld.getHeight() || x<0 || y<0)
        {
            return false;
        }
        return true;
    }
    
    
    
    //moves PacMan
    public void move()
    {
               if (canMove() && !(WallToEast()) && Greenfoot.isKeyDown("right"))
       {
           setLocation (getX()+1,getY());
           setImage("pacman_r.png");
       }
       else if (canMove() && !(WallToWest()) && Greenfoot.isKeyDown("left"))
       {
           setLocation (getX()-1,getY());
           setImage("pacman_l.png");
       }
       else if (canMove() && !(WallToNorth()) && Greenfoot.isKeyDown("up"))
       {
           setLocation (getX(),getY()-1);
           setImage("pacman_u.png");
       }
       else if (canMove() && !(WallToSouth()) && Greenfoot.isKeyDown("down"))
       {
           setLocation (getX(),getY()+1);
           setImage("pacman_d.png");
       }
    }
    
    //checks whether there is a wall to the east.
    public boolean WallToEast()
    {
        Actor Wall1 = getOneObjectAtOffset(+1,0, Wall1.class);
        Actor Wall2 = getOneObjectAtOffset(+1,0, Wall2.class);
        
        if (Wall1==null && Wall2==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    
    //checks whether there is a wall to the south.
    public boolean WallToSouth()
    {
        Actor Wall1 = getOneObjectAtOffset(0,+1, Wall1.class);
        Actor Wall2 = getOneObjectAtOffset(0,+1, Wall2.class);
        
        if (Wall1==null && Wall2==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    
    //checks whether there is a wall to the west.
    public boolean WallToWest()
    {
        Actor Wall1 = getOneObjectAtOffset(-1,0, Wall1.class);
        Actor Wall2 = getOneObjectAtOffset(-1,0, Wall2.class);
        
        if (Wall1==null && Wall2==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    
    //checks whether there is a wall to the north.
    public boolean WallToNorth()
    {
        Actor Wall1 = getOneObjectAtOffset(0,-1, Wall1.class);
        Actor Wall2 = getOneObjectAtOffset(0,-1, Wall2.class);
        
        if (Wall1==null && Wall2==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    //collects coins and cherries.
    public void collectCoin()
    {
        Actor Coin = getOneObjectAtOffset(0, 0, Coin.class);
        Actor Cherry = getOneObjectAtOffset(0, 0, Cherry.class);
        if (Coin!=null)
        {
            score++;
            
            counter2.add(1);
            Greenfoot.playSound("chomp.wav");

            getWorld().removeObject(Coin);
            
        }
        if (Cherry!=null)
        {
            score+=5;
            counter2.add(5);
            Greenfoot.playSound("chomp.wav");

            getWorld().removeObject(Cherry);
        }
        if (score==206)
        {
            Greenfoot.playSound("win.wav");
            getWorld().addObject(new YouWin(),10, 10);
            Greenfoot.stop();
        }

            
    }
    
    
    //checks whether pacman is eaten by a ghost.
    public void eatenByGhost()
    {
        Actor Ghost1 = getOneObjectAtOffset(0, 0, Ghost1.class);
        Actor Ghost2 = getOneObjectAtOffset(0, 0, Ghost2.class);
        Actor Ghost3 = getOneObjectAtOffset(0, 0, Ghost3.class);
        
        if (Ghost1!=null || Ghost2!=null || Ghost3!=null)
        {
            Greenfoot.playSound("die.mp3");
            getWorld().addObject(new Counter(1,"Score "+score),10,12);
            getWorld().addObject(new GameOver(),10,10);
            
            getWorld().removeObject(counter2);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
        
    }
    
}   



 



