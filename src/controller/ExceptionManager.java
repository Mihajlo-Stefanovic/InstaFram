package controller;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JOptionPane;
import app.AppCore;
import app.LogInCore;
import controller.commands.treeCommands.AddTreeCommand;
import controller.commands.treeCommands.RemoveTreeCommand;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.exceptions.exceptionTypes.MyExceptionType;
import model.tree.nodes.Workspace;

public class ExceptionManager {
	
	public ExceptionManager() {
		
	}

	public void handleException(MyException exception) {
		MyExceptionType type =  exception.getType();
		Exception sysException = exception.getSysException();
		
		if(type==MyExceptionSubTypes.ADDTREELISTENER.NOPROJECT) {
			exception.setMessage("No Project is Open!");
			showDialog(exception);
		}
		
		else if(type==MyExceptionSubTypes.ADDTREELISTENER.NONODESELECTED) {
			exception.setMessage("Please First Select a Node.");
			showDialog(exception);
		}
		
		else if(type==MyExceptionSubTypes.DELETENODELISTENER.DELETEROOT) {
			AppCore.getInstance().getCommandManager().addCommand(new RemoveTreeCommand());
			exception.setMessage("Project Closed.");
			showDialog(exception);
		}
		
		else if(type==MyExceptionSubTypes.LOADPROJECTLISTENER.FILEEMPTY) {
			exception.setMessage("Nothing to Read in the File.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.LOADER.IOEXCEPTION && sysException instanceof IOException) {
			exception.setMessage("Can't read the file.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.LOADPROJECTLISTENER.NEWROOTADDED) {
			exception.setMessage("New Root added!");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.NEWNODELISTENER.NOTREE) {
			AppCore.getInstance().getCommandManager().addCommand(new AddTreeCommand(new Workspace()));
		}
		
		else if(type == MyExceptionSubTypes.NEWNODELISTENER.ADDONPARAMETER) {
			exception.setMessage("Can't add on parameter.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.PARAMETERTAB.WRONGSUBTYPE) {
			exception.setMessage("Ups. Something went wrong.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.LOGIN.WRONGINFO) {
			exception.setMessage("Wrong info. Please try again.");
			showDialog(LogInCore.getInstance().getLogInFrame(),exception);
		}
		
		else if(type == MyExceptionSubTypes.LOGIN.USERALREADYEXSISTS) {
			exception.setMessage("That user already exsists.");
			showDialog(LogInCore.getInstance().getLogInFrame(),exception);
		}
		
		else if(type == MyExceptionSubTypes.PARAMETERTAB.NOTPICTURE) {
			exception.setMessage("Please chose a picture.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.PARAMETERTAB.NOTDOCUMENT) {
			exception.setMessage("Please chose a .txt document.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.NEWMODULE.NOPATH) {
			exception.setMessage("Please chose a module path.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.INSTALL.FILENOTVALID) {
			exception.setMessage("Please chose a valid file.");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.INSTALL.NOSUCHFILE) {
			exception.setMessage("No such file!");
			showDialog(exception);
		}
		
		else if(type == MyExceptionSubTypes.INSTALL.NOLOOK) {
			exception.setMessage("No look chosen!");
			showDialog(exception);
		}
	}
	
	public void showDialog(MyException exception) {
		JOptionPane.showMessageDialog(AppCore.getInstance().getMainFrame(), exception.getMessage());
	}
	
	public void showDialog(Component cmp,MyException exception) {
		JOptionPane.showMessageDialog(cmp, exception.getMessage());
	}
}
