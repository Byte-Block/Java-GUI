import java.awt.*;
import java.awt.event.*;

public class IspisivanjeTekstaUProzoru extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IspisivanjeTekstaUProzoru() {
		super("Ispisivanje Teksta U Prozoru");
		setSize(300, 200);
		add(new Label("Pozdrav svima!", Label.CENTER));
		addWindowListener(new ProzorDogadjaji());
		setVisible(true);
	}

	private class ProzorDogadjaji extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent dog) {
			dispose();
		}
	}

	public static void main(String[] varg) {
		new IspisivanjeTekstaUProzoru();
	}
}
