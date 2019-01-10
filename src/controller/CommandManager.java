package controller;

import java.util.ArrayList;

import controller.commands.Command;

public class CommandManager {
	
	private ArrayList<Command> commands;
	
	private int currentCommandIt = -1;
	
	public CommandManager() {
		commands = new ArrayList<>();
	}
	
	public void addCommand(Command command) {
		if(currentCommandIt == commands.size()-1) {
			commands.add(command);
		}
		else {
			commands.subList(currentCommandIt + 1, commands.size()).clear();
			commands.add(command);
		}
		
		currentCommandIt++;
		command.doCommand();
	}
	
	public void undoCommand() {
		if(currentCommandIt>=0) {
			commands.get(currentCommandIt).undoCommand();
			currentCommandIt--;
		}
		else {
			//TODO handle exception
		}
	}
	
	public void redoCommand() {
		if(currentCommandIt<commands.size()-1) {
			currentCommandIt++;
			commands.get(currentCommandIt).doCommand();
		}
		else {
			//TODO handle exception
		}
	}
}
