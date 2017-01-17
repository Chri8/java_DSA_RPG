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
			case "item":
				CreateItemCommand crItemComm = new CreateItemCommand(commands);
				this.cb = crItemComm.execute();
			}
			
		}
		return cb;
	}

}
