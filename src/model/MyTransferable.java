package model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class MyTransferable implements Transferable{
	private ArrayList<DataFlavor> supportedFlavors;
	private Object content;
	
	public MyTransferable(Object elements) {
		content = elements;
		supportedFlavors = new ArrayList<>();
		supportedFlavors.add(new DataFlavor(elements.getClass(), "Content Generated Flavour"));
	}
	
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (supportedFlavors.contains(flavor))
			return (content);
		else
			throw new UnsupportedFlavorException(flavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (DataFlavor[]) supportedFlavors.toArray();
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return supportedFlavors.contains(flavor);
	}

	public Object getDiagramElements() {
		return content;
	}
	

}
