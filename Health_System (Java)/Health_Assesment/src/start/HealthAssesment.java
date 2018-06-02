package start;
import javax.swing.SwingUtilities;

import gui.GUIQs;

/**
 * 
 * @author 215021437 Hlungwani T
 * HealthAssesment class 
 * Represents the creation & running of the application
 */
public class HealthAssesment {

	public static void main(String[] args) {
		//Creating a thread safe swing application
				SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						new GUIQs("Health Assesment");
					}
				});
	}

}
