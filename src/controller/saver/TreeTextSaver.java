package controller.saver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import app.AppCore;
import model.tree.nodes.MyTreeNode;

public class TreeTextSaver extends Saver {
	
	@Override
	public void save(Object o) {
		save(o,new File(AppCore.getInstance().getTree().getModel().getRoot().toString()));
	}
	
	@Override
	public void save(Object o, File file) {
		if (o instanceof MyTreeNode) {
			MyTreeNode node = (MyTreeNode) o;
			if (file != null) {

				ArrayList<String> toWrite = new ArrayList<>();
				treeToStringList(node, 0, toWrite);

				AppCore.getInstance().getTree().setSavedVersion();

				try {
					PrintWriter writer = new PrintWriter(file + ".txt");
					for (String lineToWrite : toWrite) {
						writer.println(lineToWrite);
					}
					writer.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				toWrite.clear();
			}
		}
	}

	/**
	 * Converts tree to string.
	 * 
	 * @param node    Node from which to build string tree.
	 * @param level   Internal recursion parameter. Num of '-'.
	 * @param toWrite The out parameter. Tree string is written here.
	 */
	public void treeToStringList(MyTreeNode node, int level, ArrayList<String> toWrite) {
		String nameToWrite = new String();

		for (int i = 0; i < level; i++)
			nameToWrite += "-";
		nameToWrite += node.toString();

		toWrite.add(nameToWrite);

		if (node.getDescription() != null) {
			String[] descriptionToWrite = node.getDescription().split("\n");
			for (String lineOfDesrc : descriptionToWrite) {
				toWrite.add("@" + lineOfDesrc);
			}
		}

		for (MyTreeNode child : node.getChildren()) {
			treeToStringList(child, level + 1, toWrite);
		}

	}
}
