/*
 * 
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map extends JPanel implements ActionListener{
	
	//public class Map extends JPanel implements ActionListener, Runnable{
	/** The main timer. */
	Timer mainTimer = new Timer(30, this);
	
	/** The grass. */
	Image grass = new ImageIcon("images/0.png").getImage();
	
	/** The road. */
	Image road = new ImageIcon("images/1.png").getImage();
	
	/** The lane. */
	Image lane = new ImageIcon("images/9.png").getImage();
	
	/** The number car. */
	public static int numberCar=0;
	
	 int [][] matrix = new int[25][40];
	
	//parallel creating cars
	//Thread carsFactory = new Thread(this);
	
	/** The tr light. */
	//public static boolean trLight = true;
	
	// keep list of the cars
	//List<Car> listCars = new ArrayList<Car>();
	//List<Rectangle> listRec = new ArrayList<Rectangle>();
	
	
	/**
	 * Instantiates a new map.
	 */
	public Map(){
try {	
			
			int row=0;
			int coll=40;
			int size=0;
		

			
			FileReader file = new FileReader("files/map.txt");
			@SuppressWarnings("resource")
			BufferedReader reader =new BufferedReader(file);
			
			
		
			
			
			String line = reader.readLine();
			String []spaces;		
			while(line != null)
			{
				spaces = line.trim().split("\\s+");
				
		        for (int col = 0; col <40; col++) {
		            matrix[row][col] = Integer.parseInt(spaces[col]);
		           // System.out.println("++++++ the coll +++  "+col);
		            //System.out.println(matrix[row][col]);
		        }
		
		        row++; 
				line = reader.readLine();
			    //System.out.println("-----------the row is --  "+row);
				
			}
			
			
			
			} catch (IOException e) 
			{
		    System.err.println("Caught IOException: " + e.getMessage());
		    }
		
	/*
System.out.println("this****************");
	for(int i=0; i<25; i++)
	{
		System.out.print("\n");
		for(int j=0; j<20; j++)
	{
			   System.out.print(matrix[i][j]);
	}
		
	}*/
	
		mainTimer.start();
}		
	
		
	//	carsFactory.start();
		//traficLight.start();
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	//	for(int i=0; i<20; i++)
	//	{
	//		for(int j=0; j<20; j++)
	//		{
		
				
			/*if (matrix[i][j]==0)
				{
					g.drawImage(grass, i*10, j*10, null);
				}
				
				if (matrix[i][j]==1)
				{
					g.drawImage(road, i*10, j*10, null);
				}
				if (matrix[i][j]==9)
				{
					g.drawImage(lane, i*10, j*10, null);
				}
			*/
	//		}
			
			
	//	}
		
		

	
	///////////////////////////////////////////////////////////////////////////////
		
	
		
		
		
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint (Graphics g) {
		g=(Graphics2D) g;
		/*
		g.drawImage(grass, 0, 0, null);
		g.drawImage(grass, 10, 0, null);
		g.drawImage(grass, 20, 0, null);
		g.drawImage(road, 30, 0, null);
		g.drawImage(road, 40, 0, null);
		g.drawImage(grass, 50, 0, null);
		g.drawImage(grass, 60, 0, null);
		
		
		
	*/
		
		
		int px=0;
		int py=0;
		
		
		for(int y=0; y<25; y++)
		{
			for(int x=0; x<40; x++)
			{
			
			if (matrix[y][x]==0)
				{	
				
					g.drawImage(grass, px, py, null);
					px=x*10;
					py=y*10;
				
				}
				
				if (matrix[y][x]==1)
				{

					g.drawImage(road, px, py, null);
					px=x*10;
					py=y*10;
				
				}
				if (matrix[y][x]==2)
				{	
					g.drawImage(road, px, py, null);
					px=x*10;
					py=y*10;
				
				}
				if (matrix[y][x]==9)
				{
					g.drawImage(lane, px, py, null);
					px=x*10;
					py=(y*10);	

				}
	
			}
			
			
		}
		
				
		
		
		
		
		
		//drawing the car		
	/*	Iterator<Car> i = listCars.iterator();
		while(i.hasNext()){
			Car myCar = i.next();
			testCrash(myCar);
			
			
				if((myCar.x>-60 && myCar.x<1010) && (myCar.y>-20 && myCar.y<510))
				{
				  
				  myCar.Drive();
			      g.drawImage(myCar.img, myCar.x, myCar.y, null);
			      g.drawImage(light, 438, 180, null);
				}
				else{
					i.remove();
				}
			      	}
*/
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed (ActionEvent e){
	
		repaint();
		
	}
/*
	
	public void testCrash(Car myCar) {
		
	
		Iterator<Car> iter = listCars.iterator();
		while(iter.hasNext()){
			
			while(iter.hasNext()){
				Car otherCars = iter.next();
				if(myCar.myCase==1 || myCar.myCase==2){
		    if(((myCar.getRect1().intersects(otherCars.getRect1())) && (myCar.hashCode()!=otherCars.hashCode())) && (myCar.number!=otherCars.number))
		{
		    	otherCars.DriveSlow(myCar.myCase);
		    	
		}}
				
				if(myCar.myCase==3 || myCar.myCase==4)
				    if(((myCar.getRect2().intersects(otherCars.getRect2())) && (myCar.hashCode()!=otherCars.hashCode())) && (myCar.number!=otherCars.number))
				{
				    	otherCars.DriveSlow(myCar.myCase);
				    	
				}
	 }
	}
}
*/
	
	
	//@Override
//	public void run() {
	/*	while(true){
		
			
			try {
				Thread.sleep(2000);
								if (trLight)
			{
				System.out.println("Green");
				light = new ImageIcon("resources/green.png").getImage();
				
			trLight= false;
		}
		else{
			light = new ImageIcon("resources/red.png").getImage();
			trLight=true;
			System.out.println("Red");
		}
			
				
			} catch (InterruptedException e) {
				e.printStackTrace();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
			}
	

				Random randomCars = new Random();
			
			try {
				Thread.sleep(randomCars.nextInt(500));
				int mCase=randomCars.nextInt(5)+1;
		
				
				
				switch(mCase)
				{
					case 1:
						//from west to east    randomCars.nextInt(5)+1
						listCars.add(new Car(mCase, -25, 185, randomCars.nextInt(5)+1 ,numberCar, this));
						numberCar++;
						break;
						
					case 2:
						//from east to west
						listCars.add(new Car(mCase, 1000, 228, randomCars.nextInt(5)+1, numberCar, this));
						numberCar++;
						break;
					
					case 3:
						//from north to sought
						listCars.add(new Car(mCase, 505, -5, randomCars.nextInt(5)+1, numberCar, this));
						numberCar++;
						break;
					
					case 4:
						//from sought to north
						listCars.add(new Car(mCase, 464, 450, randomCars.nextInt(5)+1, numberCar, this));
						numberCar++;
						break;
						
					case 5:
						//from west to east    randomCars.nextInt(5)+1
						listCars.add(new Car(mCase, -25, 185, randomCars.nextInt(5)+1 ,numberCar, this));
						numberCar++;
						break;
						

				}
				
		
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		*/
	//}
}
