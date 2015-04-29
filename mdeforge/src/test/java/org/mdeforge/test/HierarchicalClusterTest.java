package org.mdeforge.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.apporiented.algorithm.clustering.Cluster;
import com.apporiented.algorithm.clustering.ClusteringAlgorithm;
import com.apporiented.algorithm.clustering.DefaultClusteringAlgorithm;
import com.apporiented.algorithm.clustering.SingleLinkageStrategy;
import com.apporiented.algorithm.clustering.visualization.DendrogramPanel;

public class HierarchicalClusterTest {

	public static void main(String[] args) {
		String[] names = new String[] { "O1", "O2", "O3", "O4", "O5", "O6" };
		double[][] distances = new double[][] { 
		    { 0, 1, 9, 7, 11, 14 },
		    { 1, 0, 4, 3, 8, 10 }, 
		    { 9, 4, 0, 9, 2, 8 },
		    { 7, 3, 9, 0, 6, 13 }, 
		    { 11, 8, 2, 6, 0, 10 },
		    { 14, 10, 8, 13, 10, 0 }};

		ClusteringAlgorithm alg = new DefaultClusteringAlgorithm();
		Cluster cluster = alg.performClustering(distances, names,
		    new SingleLinkageStrategy());
		
		DendrogramPanel dp = new DendrogramPanel();
		dp.setModel(cluster);
		int w = 1000;
	    int h = 1000;
	    dp.setSize(w, h);
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	    dp.paint(g);
	    dp.print(g);
	    File outputfile = new File("/Users/juridirocco/Desktop/tempForge/asd.jpx");
	    try {
			ImageIO.write(bi, "jpg", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
