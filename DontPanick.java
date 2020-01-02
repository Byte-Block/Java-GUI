import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DontPanick extends Frame {

	private Button dontPanick;

	private DontPanick() {
		super("Don't Panick!");
		setLocation(550, 300);
		setSize(300, 200);
		// setBounds(550, 300, 300, 200);
		addWindowListener(new WindowEvents());
		setLayout(null);
		add(new Label("Don't panick, and just push the button!")).setBounds(45, 50, 209, 60);
		add(dontPanick = new Button("DONT PANICK!")).setBounds(100, 130, 100, 40);
		dontPanick.setBackground(Color.RED);
		dontPanick.setForeground(Color.YELLOW);
		dontPanick.addActionListener(new DontPanickAction());
		dontPanick.addMouseListener(new DontPanickEventsMouse());
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
		new DontPanick();
	}

}
