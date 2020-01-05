package calculator;

import java.awt.*;
import java.awt.event.*;
//WORK IN PROGRESS!!!
public class Calculator extends Frame {

	String[] baseNumeralSystem = {"2", "8", "10", "16"};
	private int base = 10;
	
	private long x=0, y=0;
	private Label[] registry = new Label[2];
	private static final int X = 0, Y = 1;
	
	private Panel panelRegistry() {
		Panel panel = new Panel(new GridLayout(2,1));
		Color[] baseColor = {Color.orange, Color.gray};
		Color[] lettersColor = {Color.blue, Color.white};
		for (int i = 0; i < 2 ; i++) {
			registry[i] = new Label("0", Label.RIGHT);
					registry[i].setFont(new Font(null, Font.BOLD, 20));
							registry[i].setForeground(lettersColor[i]);
									registry[i].setBackground(baseColor[i]);
										panel.add(registry[i]);
		}
		return panel;
	}
	
	private void showing() {
		registry[X].setText(Long.toString(x, base));
		registry[Y].setText(Long.toString(y, base));
	}
	
	private Button[] numbers = new Button[16];
	private boolean newNumber = true;
	
	private Panel panelNumbers() {
		Panel panel = new Panel(new GridLayout(4,4));
		//NumberAction listener = new NumberAction();
		for (int i = 0 ; i < 16 ; i++) {
			panel.add(numbers[i] = new Button(Integer.toString(i,16)));
			//numbers[i].addActionListener(listener);
			numbers[i].setEnabled(i < base);
		}
		return panel;
	}
	
	private class NumberAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}
