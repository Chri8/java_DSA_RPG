import java.util.ArrayList;

public abstract class AbstractCommand implements Command{
	protected CallBack cb = new CallBack();
	protected ArrayList<String> commands;
	AbstractCommand(ArrayList<String> commands){this.commands=commands;}

}
