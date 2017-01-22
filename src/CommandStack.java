import java.util.ArrayList;

public class CommandStack {
	ArrayList<String> commandStack = new ArrayList<String>();
	private String command = null;
	private ArrayList<String>  commandArguments =new ArrayList<String>();
	private int pointer = 0;
	public void deleteCommandStack(){
		commandStack.clear();
		commandArguments.clear();
		command = null;
	}
	public void increasePointer(){
		if (this.pointer<(this.getCommStackSize()-1)) ++this.pointer;
	}
	public void decreasePointer(){
		if (this.pointer>0) --this.pointer;
	}
	public int getPointer(){return this.pointer;}
	
	public void setCommandStack(String [] commands){
		deleteCommandStack();
		for(String c:commands){
			commandStack.add(c);
		}
		for (int i=0;i<commands.length;i++){
			if (i==0){command = commands[0];}
			else
			{commandArguments.add(commands[i]);}
		}
		
	}
	public String [] getCommands(){
		return commandStack.toArray( new String [commandStack.size()]);}
	
	public String getCommandStackValues(){
		String returnVal = "";
		for(int i=0;i<this.commandStack.size();i++){
			returnVal+=i+") "+this.commandStack.get(i)+"\n";
		}
		return returnVal;
	}
	public int getCommStackSize(){return this.commandStack.size();}
	public String getMainCommand(){
		// returns the command
		return command;
	}
	public String getCommandArgumentsAsString(){
		String retVal="";
		for (String s:commandArguments){
			retVal+=(s+" ");
			
		}
		return retVal.trim();
	}
	public ArrayList<String> getCommandArgumentsList(){

		return commandArguments;
	}
	public ArrayList<String> getCommandList(){
		return commandStack;
	}

}
