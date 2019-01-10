package controller.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import app.AppCore;
import model.tree.nodes.MyTreeNode;

public class TreeTextLoader extends Loader{
	
	@Override
	public void load(File file, Object o) {
		MyTreeNode node = (MyTreeNode) o;
		
		assert file != null : "No File";
		assert node != null : "No Node";
		try {
			ArrayList<String> linesFromFile = new ArrayList<String>();
			String line;

			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();

			while (line != null) {
				linesFromFile.add(line);
				line = bufferedReader.readLine();
			}
			addStringListToNode(linesFromFile, node);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void addStringListToNode(ArrayList<String> linesFromFile, MyTreeNode node) {
		ArrayList<String> linesFromFileCPY = new ArrayList<>();

		// copying linesFromFile, to preserve original content
		for (String line : linesFromFile) {
			linesFromFileCPY.add(new String(line));
		}

		while (linesFromFileCPY.size() > 0)
			node.add(stringListToTree(linesFromFileCPY));
	}

	/**
	 * Returns node with all of its children added. Only takes the first tree from
	 * the string list. If more than one root node is present, returns only the
	 * first with its children.
	 * 
	 * @param
	 * @return
	 */
	private MyTreeNode stringListToTree(ArrayList<String> linesFromFile) {
		MyTreeNode node = null;
		try {
		// if array is empty
		if (linesFromFile.size() == 0)
			return null;

		node = new MyTreeNode(getNodeNameFromFileLine(linesFromFile.get(0)));

		int currDepth = getNodeDepthFromFileLine(linesFromFile.get(0));
		
		linesFromFile.remove(0);
		
		//empty line
		if(node.getName().isEmpty())
			return null;
		
		//description
		while(linesFromFile.size() >= 1 && !linesFromFile.get(0).isEmpty() && linesFromFile.get(0).charAt(0)=='@') {			
			String descriptionToSet;
			if(node.getDescription()!=null)
				descriptionToSet = node.getDescription() + '\n' + linesFromFile.get(0).substring(1);
			else
				descriptionToSet = linesFromFile.get(0).substring(1);
			node.setDescription(descriptionToSet);
			linesFromFile.remove(0);
		}
		
		// end of array, node has no children
		if (linesFromFile.size() == 0)
			return node;

		// determined that node has no children
		if (getNodeDepthFromFileLine(linesFromFile.get(0)) <= currDepth) {
			return node;
		}

		// determined that node has children
		while (linesFromFile.size() >= 1 && getNodeDepthFromFileLine(linesFromFile.get(0)) > currDepth) {
			node.add(stringListToTree(linesFromFile));
		}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(AppCore.getInstance().getMainFrame(), "File is not valid.");
		}
		return node;
	}

	private String getNodeNameFromFileLine(String stringNode) {
		return stringNode.substring(getNodeDepthFromFileLine(stringNode));
	}

	private int getNodeDepthFromFileLine(String stringNode) {
		int depth = 0;
		for (int i = 0; i < stringNode.length(); i++) {
			if (stringNode.charAt(i) == '-') {
				depth++;
			} else
				return depth;
		}
		return depth;
	}
}
