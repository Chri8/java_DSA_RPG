import javax.swing.JTextArea;

public class CommandExecutor {
	JTextArea jta;
	private Command lockingCommand = null; // Command which locks the input to itself until end of execution
	public void executeCommandStack(CommandStack commStack){
		if (lockingCommand !=null){
			printOut(lockingCommand.getClass().getName());
			redirectToCommand(lockingCommand, commStack);
		}
		if (commStack.getCommStackSize()>0){
			switch(commStack.getMainCommand()){
			case "create":
				CreateCommand crcomm= new CreateCommand(commStack.getCommandArgumentsList());
				CallBack cb = crcomm.execute();
				executeCallback(cb);
				

				
			}
				
		}
		else{
			printOut("Command Stack is Empty, nothing to execute");
		}
	}
	private void executeCallback(CallBack cb){
		printOut(cb.question);
		
		if (cb.closeOnItself) setLock(cb.command);
		else releaseLock();
	}
	private void releaseLock(){this.lockingCommand = null;}
	private void setLock(Command c){this.lockingCommand = c;}
	private void redirectToCommand(Command c, CommandStack cs){
		c.setArguments(cs);
		CallBack cb = c.execute();
		executeCallback(cb);
	}
	public void setLoggingFacility(JTextArea jt){
		this.jta = jt;
	};
	private JTextArea getLoggingFacility(){return jta;}
	private void printOut(String text){getLoggingFacility().append(text+"\n");}
	
}
