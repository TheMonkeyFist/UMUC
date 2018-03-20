import javax.swing.JOptionPane;

public class CycleDetectedException extends Exception{
	public CycleDetectedException() {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, "CycleDetected");
	}
	public CycleDetectedException(String e) {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, e);
	}
}
