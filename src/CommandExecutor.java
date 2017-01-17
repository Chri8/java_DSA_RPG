import javax.swing.JTextArea;

public class CommandExecutor {
	JTextArea jta;
	private Command lock = null; // Command which locks the input to itself until end of execution
	public void executeCommandStack(CommandStack commStack){
	
		if (commStack.getCommStackSize()>0){
			switch(commStack.getMainCommand()){
			case "create":
				CreateCommand crcomm= new CreateCommand(commStack.getCommandArgumentsList());
				this.lock = crcomm.execute().command;
			}
				
		}
		else{
			printOut("Command Stack is Empty, nothing to execute");
		}
	}
	private void setLock(Command c){this.lock = c;}

	public void setLoggingFacility(JTextArea jt){
		this.jta = jt;
	};
	private JTextArea getLoggingFacility(){return jta;}
	private void printOut(String text){getLoggingFacility().append(text+"\n");}
	
}
