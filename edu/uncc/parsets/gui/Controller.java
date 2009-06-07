package edu.uncc.parsets.gui;

import java.util.ArrayList;

import edu.uncc.parsets.data.CategoryHandle;
import edu.uncc.parsets.data.DataSet;
import edu.uncc.parsets.data.DimensionHandle;
import edu.uncc.parsets.parsets.RibbonLayoutStyle;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\
 * Copyright (c) 2009, Robert Kosara, Caroline Ziemkiewicz,
 *                     and others (see Authors.txt for full list)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the name of UNC Charlotte nor the names of its contributors
 *      may be used to endorse or promote products derived from this software
 *      without specific prior written permission.
 *      
 * THIS SOFTWARE IS PROVIDED BY ITS AUTHORS ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
\* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Controller {

	private ArrayList<DataSetListener> dsListeners = new ArrayList<DataSetListener>();
	private ViewListener viewListener;
	
	public Controller() {
		
	}
	
	public void addDataSetListener(DataSetListener l) {
		dsListeners.add(l);
	}

	public void removeDataSetListener(DataSetListener l) {
		dsListeners.remove(l);
	}

	public void setDataSet(DataSet data) {
		for (DataSetListener l : dsListeners)
			l.setDataSet(data);
	}

	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}
	
	public void setRibbonStyle(RibbonLayoutStyle ribbonStyle) {
		viewListener.setRibbonStyle(ribbonStyle);
	}
	
	public void addAxis(DimensionHandle dimension) {
		viewListener.addAxis(dimension);
	}
	
	public void removeAxis(DimensionHandle dimension) {
		viewListener.removeAxis(dimension);
	}
	
	public void removeCategory(DimensionHandle dimension, CategoryHandle category) {
		viewListener.removeCategory(dimension, category);
	}
	
	public void addCategory(DimensionHandle dimension, CategoryHandle category) {
		viewListener.addCategory(dimension, category);
	}

	public void clearScreen() {
		viewListener.clearScreen();
	}

	public void setShowTooltips(boolean show) {
		viewListener.setShowTooltips(show);
	}

	public void screenShot(String fileName) {
		viewListener.takeScreenShot(fileName);
	}

	public void antiAlias(boolean aa) {
		viewListener.setAntiAlias(aa);
	}
	
}
