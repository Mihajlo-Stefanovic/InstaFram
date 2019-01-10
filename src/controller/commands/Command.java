package controller.commands;

public interface Command {
	public abstract void doCommand();
	public abstract void undoCommand();
}
