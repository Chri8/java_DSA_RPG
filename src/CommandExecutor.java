import javax.swing.JTextArea;

public class CommandExecutor {
	JTextArea jta;
	public void executeCommandStack(CommandStack commStack){
		if (commStack.getMainCommand()!=null){
			switch(commStack.getMainCommand()){
			case "create": printOut("i will create "+commStack.getCommandArgumentsAsString());break;
			case "delete": printOut("i will delete "+commStack.getCommandArgumentsAsString());break;
			default:printOut("i dont know this command: "+commStack.getMainCommand());
			}
		}
		else{
			printOut("Command Stack is Empty, nothing to execute");
		}
	}
	public void setLoggingFacility(JTextArea jt){
		this.jta = jt;
	};
	private JTextArea getLoggingFacility(){return jta;}
	private void printOut(String text){getLoggingFacility().append(text+"\n");}
	
}
