import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DontPanic extends Frame {

	private Button dontPanic;

	private DontPanic() {
		super("Don't Panic!");
		setLocation(550, 300);
		setSize(300, 200);
		addWindowListener(new WindowEvents());
		setLayout(null);
		add(new Label("Don't panic, and just push the button!")).setBounds(45, 50, 210, 60);
		add(dontPanic = new Button("DONT PANIC!")).setBounds(100, 130, 100, 40);
		dontPanic.setBackground(Color.RED);
		dontPanic.setForeground(Color.YELLOW);
		dontPanic.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 12));
		dontPanic.addActionListener(new DontPanicAction());
		dontPanic.addMouseListener(new DontPanicEventsMouse());
		setVisible(true);
	}

	private class WindowEvents extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			dispose();
		}
	}

	private class DontPanickAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}

	}

	private class DontPanickEventsMouse extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			dispose();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DontPanic();
	}

}
