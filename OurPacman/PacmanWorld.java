import greenfoot.*;

/**
 * Write a description of class PacmanWorld here.
 * 
 * @author (ChorG) 
 * @version (20/8/2015)
 */
public class PacmanWorld extends World
{
    
    public Counter counter1;
    /**
     * Constructor for objects of class PacmanWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(21, 22, 20);
        Greenfoot.setSpeed(35);
        setPaintOrder(YouWin.class,Counter.class,GameOver.class,Wall1.class, Wall2.class, Pacman.class, Ghost1.class, Ghost2.class, Ghost3.class);
        Counter counter = new Counter("   Score ");
        counter1=counter;
        addObject(counter,1,10);
        Greenfoot.playSound("start.wav");
        SetAndCreateLayout();


        
    }

    public void SetAndCreateLayout()
    {
        //Assigns a number to each structure in layout.
        int array[]={0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,
                0,2,9,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,9,2,0,
                0,2,1,3,3,1,3,3,3,1,3,1,3,3,3,1,3,3,1,2,0,
                0,2,1,3,3,1,3,3,3,1,3,1,3,3,3,1,3,3,1,2,0,
                0,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,0,
                0,2,1,3,3,1,3,1,3,3,3,3,3,1,3,1,3,3,1,2,0,
                0,2,1,1,1,1,3,1,1,1,3,1,1,1,3,1,1,1,1,2,0,
                0,2,2,2,2,1,3,3,3,1,3,1,3,3,3,1,2,2,2,2,0,
                0,0,0,0,2,1,3,1,1,1,1,1,1,1,3,1,2,0,0,0,0,
                0,0,0,0,2,1,3,1,2,4,2,4,2,1,3,1,2,0,0,0,0,
                0,0,0,0,2,1,1,1,2,6,7,8,2,1,1,1,2,0,0,0,0,
                0,0,0,0,2,1,3,1,2,2,2,2,2,1,3,1,2,0,0,0,0,
                0,0,0,0,2,1,3,1,1,1,1,1,1,1,3,1,2,0,0,0,0,
                2,2,2,2,2,1,3,1,3,3,3,3,3,1,3,1,2,2,2,2,2,
                2,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,2,
                2,1,3,3,3,1,3,3,3,1,3,1,3,3,3,1,3,3,3,1,2,
                2,1,1,1,3,1,1,1,1,1,5,1,1,1,1,1,3,1,1,1,2,
                2,3,3,1,3,1,3,1,3,3,3,3,3,1,3,1,3,1,3,3,2,
                2,1,1,1,1,1,3,1,1,1,3,1,1,1,3,1,1,1,1,1,2,
                2,1,3,3,3,3,3,3,3,1,3,1,3,3,3,3,3,3,3,1,2,
                2,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,2,
                2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};

        createLayout(array);
    }

    public void createLayout(int array[])
    {
        removeObjects(getObjects(Wall1.class));
        removeObjects(getObjects(Wall2.class));
        removeObjects(getObjects(Ghost1.class));
        removeObjects(getObjects(Pacman.class));
        removeObjects(getObjects(Ghost2.class));
        removeObjects(getObjects(Ghost3.class));
        removeObjects(getObjects(Gate.class));
        removeObjects(getObjects(Coin.class));
        int count=0;
        int x,y;
        for (y=0;y<22;y++)
        {
            for (x=0;x<21;x++)
            {
                int structure=array[count];
                if (structure==0)
                {}
                else if (structure==1)
                {
                    addObject(new Coin(),x,y);
                }
                else if (structure==2)
                {
                    addObject(new Wall1(),x,y);
                }
                else if (structure==3)
                {
                    addObject(new Wall2(),x,y);
                }
                else if (structure==4)
                {
                    addObject(new Gate(),x,y);
                }
                else if (structure==5)
                {
                    addObject(new Pacman(counter1),x,y);
                }
                else if (structure==6)
                {
                    addObject(new Ghost1(),x,y);
                }                
                else if (structure==7)
                {
                    addObject(new Ghost2(),x,y);
                }
                else if (structure==8)
                {
                    addObject(new Ghost3(),x,y);
                }
                else if (structure==9)
                {
                    addObject(new Cherry(),x,y);
                }

                if (count<array.length-1)
                {
                    count++;
                }
            }
        }

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */

}

            

            