package interfaceGraphique;

import java.awt.Dimension;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class erreurView extends JFrame{
	static public erreurView instance;
	public JScrollPane pane;
	public erreurView(){
	instance=this;
	JTextArea console = new JTextArea();
	console.setEditable(false);
	console.setWrapStyleWord(true);
	console.setLineWrap(true);
	pane = new JScrollPane(console, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	pane.setPreferredSize(new Dimension(50, 100));
	//pane.setBounds(10, 10, 300, 100);
	//bas.add(console);
	this.add(pane);
	
	PrintStream out = new PrintStream( new TextAreaOutputStream( console ) );
	System.setOut(out);
	System.setErr(out);
	//System.out.println("Hello World");
	this.setSize(200, 200);
	this.setVisible(true);
	this.setLocation(100000, 100000);
	}

}
