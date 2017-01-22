import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javafx.scene.control.ScrollPane;

public class GameClient extends JFrame{
	JPanel jp = new JPanel();
	JTextField textField = new JTextField(30);
	JTextArea textArea = new JTextArea(20, 30);
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	CommandStack commStack;
	GameClient(CommandStack cs, CommandExecutor cex){
		commStack = cs;
		textArea.setEditable(true);
		cex.setLoggingFacility(textArea); // set where the answers of the commEx will be output to
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cs.setCommandStack(textField.getText().split("\\s"));
				
				textArea.append(cs.getCommandStackValues()); // print command stack for debugging purpose
				cex.executeCommandStack(cs);
				cs.deleteCommandStack();
				textField.setText("");
			}
		});
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jp.add(scrollPane);
		jp.add(textField);
		jp.add(scrollPane);
		
		this.add(jp);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
		textField.requestFocusInWindow();

	}
}
