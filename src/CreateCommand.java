import java.util.ArrayList;

public class CreateCommand extends AbstractCommand {

	CreateCommand(ArrayList<String> cs) {
		super(cs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CallBack execute() {
		if (this.commands.size()>0){
			switch (this.commands.get(0)){
			case "character":
				CreateCharacterCommand crCharComm = new CreateCharacterCommand(commands);
				this.cb = crCharComm.execute();
				break;
			case "item":
				CreateItemCommand crItemComm = new CreateItemCommand(commands);
				this.cb = crItemComm.execute();
				break;
			default:
				this.cb = new CallBack();
				this.cb.command = this;
				this.cb.closeOnItself=true;
				this.cb.question="create what?";
				
				break;
			}
			
		}
		return cb;
	}

	@Override
	public void setArguments(CommandStack cs) {
		this.commands = cs.getCommandList();
		this.execute();

	}


}
