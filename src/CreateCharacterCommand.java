import java.util.ArrayList;

public class CreateCharacterCommand extends AbstractCommand {

	CreateCharacterCommand(ArrayList<String> cs) {
		super(cs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CallBack execute() {
		if (this.commands.size()>0){
			this.cb = new CallBack();
			this.cb.command = this;
			this.cb.closeOnItself=false;
			this.cb.question="create character command execution end";

		}
		return cb;
	}


}
