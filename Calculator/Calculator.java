package calculator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.Border;

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
		NumberAction listener = new NumberAction();
		for (int i = 0 ; i < 16 ; i++) {
			panel.add(numbers[i] = new Button(Integer.toString(i,16)));
			numbers[i].addActionListener(listener);
			numbers[i].setEnabled(i < base);
		}
		return panel;
	}
	
	private class NumberAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String number = ((Button)e.getSource()).getLabel();
			String previousNumber = registry[Y].getText();
			registry[Y].setText((newNumber || previousNumber.contentEquals("0") ? "" : previousNumber) + number);
				newNumber = false;
				try {
					y = Long.parseLong(registry[Y].getText(), base);
				}
				catch (NumberFormatException nfe) {
					registry[Y].setText("E R R O R !");
					newNumber = true;
				}
		}
		
	}
	
	private Panel panelBases() {
		Panel panel = new Panel(new GridLayout(baseNumeralSystem.length,1));
		panel.setBackground(Color.yellow);
		CheckboxGroup group = new CheckboxGroup();
		BaseChange listener = new BaseChange();
		for (String string : baseNumeralSystem) {
			Checkbox radio = new Checkbox (string, group, Integer.parseInt(string) == base);
			panel.add(radio);
			radio.addItemListener(listener);
		}
		return panel;
	}
	
	private class BaseChange implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			String label = ((Checkbox)arg0.getSource()).getLabel();
			base = Integer.parseInt(label);
			for (int i = 0 ; i < 16 ; i++) {
				numbers[i].setEnabled( i < base);
			}
			showing();
		}
	}
	
	String[] operations = {"=","0","+=","|=","-=","^=","*=","&=","/=","<<=","%=",">>="};
	
	private Panel panelOperators() {
		Panel panel = new Panel(new GridLayout(0,2));
		OperationAction listener = new OperationAction();
		for (String string : operations) {
			Button button = new Button(string);
			button.setForeground(Color.blue);
			button.setBackground(Color.yellow);
			button.addActionListener(listener);
			panel.add(button);
		}
		return panel;
	}
	
	private class OperationAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				switch(((Button)e.getSource()).getLabel().charAt(0)) {
					case '=' : x = y;
						break;
					case '+' : x += y;
						break;
					case '-' : x -= y;
						break;
					case '*' : x *= y;
						break;
					case '/' : x /= y;
						break;
					case '%' : x %= y;
						break;
					case '0' : y = 0;
						break;
					case '|' : x |= y;
						break;
					case '&' : x &= y;
						break;
					case '^' : x ^= y;
						break;
					case '<' : x <<= y;
						break;
					case '>' : x >>= y;
						break;
				}
				showing();
			} catch (ArithmeticException ae) {
				registry[Y].setText("E R R O R !");
			}
			newNumber = true;
		}
	}
	
	private boolean dispose = false;
	
	public Calculator(int x, int y) {
		super("Calculator");
		setBounds(x, y, 305, 238);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
			 if(dispose) dispose();
			 else setVisible(false);
			}
		});
		add(panelRegistry(), BorderLayout.NORTH);
		add(panelNumbers(), BorderLayout.CENTER);
		add(panelOperators(), BorderLayout.EAST);
		add(panelBases(), BorderLayout.WEST);
	}
	
	public Calculator() {
		this(0, 0);
	}
	
	public long result() {
		return x;
	}
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		calculator.setVisible(true);
		calculator.dispose = true;
	}
}

