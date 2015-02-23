/*
 * 
 */
import javax.swing.*;


// TODO: Auto-generated Javadoc
/**
 * The Class SimulationMain.
 */
public class SimulationMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		JFrame f= new JFrame("Java F1");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(950, 500);
		f.add(new Map());
		f.setVisible(true);

	}

}
