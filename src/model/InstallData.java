package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.tree.nodes.parameterContainers.ParameterContainer;

public class InstallData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2304761639928700629L;

	private ArrayList<ParameterContainer> defaultContainers;
	
	private ArrayList<Pair<Pair<String, String>, ArrayList<ParameterContainer>>> modules;
	
	public InstallData() {
		defaultContainers = new ArrayList<>();
		modules = new ArrayList<>();
	}

	public ArrayList<ParameterContainer> getDefaultContainers() {
		return defaultContainers;
	}

	public void setDefaultContainers(ArrayList<ParameterContainer> defaultContainers) {
		this.defaultContainers = defaultContainers;
	}

	public ArrayList<Pair<Pair<String, String>, ArrayList<ParameterContainer>>> getModules() {
		return modules;
	}

	public void setModules(ArrayList<Pair<Pair<String, String>, ArrayList<ParameterContainer>>> modules) {
		this.modules = modules;
	}
	
	public void sortContainers() {
		Comparator<ParameterContainer> comparator = new Comparator<ParameterContainer>() {
			@Override
		    public int compare(ParameterContainer p1, ParameterContainer p2) {
		        return p1.priority.compareTo(p2.priority);
		    }
		};
		
		Collections.sort(defaultContainers, comparator);
		
		for (Pair<Pair<String,String>,ArrayList<ParameterContainer>> module : modules) {
			Collections.sort(module.getSecond(),comparator);
		}
	}
}
