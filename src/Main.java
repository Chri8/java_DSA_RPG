

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CommandStack cs = new CommandStack();
		CommandExecutor comex = new CommandExecutor();
		GameClient gc = new GameClient(cs, comex);
			

	}

}
