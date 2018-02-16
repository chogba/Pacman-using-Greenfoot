import greenfoot.*;

/**
 * Write a description of class Ghost here.
 * 
 * @author (ChorG) 
 * @version (20/8/2015)
 */
public class Ghost1 extends Ghost
{
    private static final int NORTH =0;
    private static final int SOUTH =1;
    private static final int EAST =2;
    private static final int WEST =3;
    
    private int direction;
    public int turn;
    
    public Ghost1()
    {
        setDirection(NORTH);
    }
    
        
    public void act() 
    {
        if (canMove())
        {
            move();
        }
        else
        {
            turn();
        }
    }   
    
    
    
    
    public boolean canMove()
    { 
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight() || x < 0 || y < 0)
        {    
            return false;
        }    
        return true;
    }
    
    
    
    
    public void move()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        if (direction==NORTH && WallToNorth())
        {
            setLocation(getX(),getY()-1);
        }
        else if (direction==SOUTH && WallToSouth())
        {
            setLocation(getX(),getY()+1);
        }
        else if (direction==EAST && WallToEast())
        {
            setLocation(getX()+1,getY());
        }
        else if (direction==WEST && WallToWest())
        {
            setLocation(getX()-1,getY());
        }
        else
        {
            turn();
        }
    }
    
    
    
   public boolean WallToNorth()
   {
       Actor Wall1 = getOneObjectAtOffset(0, -1, Wall1.class);
       Actor Wall2 = getOneObjectAtOffset(0, -1, Wall2.class);
       
       if (Wall1 != null)
       {
           return false;
       }
       else if (Wall2 != null)
       {
           return false;
       }
       else
       {
           return true;
       }
   }
   
   
   
   
   public boolean WallToSouth()
   {
       Actor Wall1 = getOneObjectAtOffset(0, +1, Wall1.class);
       Actor Wall2 = getOneObjectAtOffset(0, +1, Wall2.class);
       
       if (Wall1 != null)
       {
           return false;
       }
       else if (Wall2 != null)
       {
           return false;
       }
       else
       {
           return true;
       }
   }
   
   
   
   
   public boolean WallToEast()
   {
       Actor Wall1 = getOneObjectAtOffset(+1, 0, Wall1.class);
       Actor Wall2 = getOneObjectAtOffset(+1, 0, Wall2.class);
       
       if (Wall1 != null)
       {
           return false;
       }
       else if (Wall2 != null)
       {
           return false;
       }
       else
       {
           return true;
       }
   }
   
   
   
   
   public boolean WallToWest()
   {
       Actor Wall1 = getOneObjectAtOffset(-1, 0, Wall1.class);
       Actor Wall2 = getOneObjectAtOffset(-1, 0, Wall2.class);
       
       if (Wall1 != null)
       {
           return false;
       }
       else if (Wall2 != null)
       {
           return false;
       }
       else
       {
           return true;
       }
   }
   
   
   
   
   public void turn()
   {
       turn=Greenfoot.getRandomNumber(2);
       if (turn==0)
       {
           turnRight();
       }
       else if (turn==1)
       {
           turnLeft();
       }
   } 
   
   
   
   
   public void turnRight()
   {
       if (direction==NORTH)
       {
           setDirection(EAST);
       }
       else if (direction==EAST)
       {
           setDirection(SOUTH);
       }
       else if (direction==SOUTH)
       {
           setDirection(WEST);
       }
       else if (direction==WEST)
       {
           setDirection(NORTH);
       }
   }
   
   
   
   
   public void turnLeft()
   {  
       if (direction==NORTH)
       {
           setDirection(WEST);
       }
       else if (direction==EAST)
       {
           setDirection(NORTH);
       }
       else if (direction==SOUTH)
       {
           setDirection(EAST);
       }
       else if (direction==WEST)
       {
           setDirection(SOUTH);
       }
       
   }
   
   
   
   
   public void setDirection(int direction)
   {
       this.direction=direction;
   }
       
   
       
 
            
            
            
             
            
      
}
