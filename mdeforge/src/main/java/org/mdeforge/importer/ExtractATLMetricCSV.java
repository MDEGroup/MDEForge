package org.mdeforge.importer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.integration.MetricRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtractATLMetricCSV {
	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		ATLTransformationService as = context
				.getBean(ATLTransformationService.class);
		MetricRepository mr = context
				.getBean(MetricRepository.class);
		List<ATLTransformation>	lt = as.findAll();
		PrintWriter out = new PrintWriter("trafos.csv");
		ATLTransformation t = lt.get(0);
		List<Metric> ml = mr.findByArtifactId(new ObjectId(t.getId()));
		String testata = ";";
		for (Metric metric : ml) {
			if(metric instanceof AggregatedIntegerMetric) {
				testata+=metric.getName()+"_Avq;"+metric.getName()+"_Max;"+metric.getName()+"_Med;"+metric.getName()+"_Min;"+metric.getName()+"_StD;";
			}
			if(metric instanceof AggregatedRealMetric) {
				testata+=metric.getName()+"_Avq;"+metric.getName()+"_Max;"+metric.getName()+"_Med;"+metric.getName()+"_Min;"+metric.getName()+"_StD;";
			}
			if(metric instanceof SimpleMetric) {
				testata+=metric.getName()+";";
			}
		}
		out.println(testata);
		String body = "";
		
		for (ATLTransformation atlTransformation : lt) {
			
			ml = mr.findByArtifactId(new ObjectId(atlTransformation.getId()));
			body = atlTransformation.getName()+";";
			for (Metric metric : ml) {
				if(metric instanceof AggregatedIntegerMetric) {
					body+=((AggregatedIntegerMetric)metric).getAverage()+";";
					body+=((AggregatedIntegerMetric)metric).getMaximum()+";";
					body+=((AggregatedIntegerMetric)metric).getMedian()+";";
					body+=((AggregatedIntegerMetric)metric).getMinimum()+";";
					body+=((AggregatedIntegerMetric)metric).getStandardDeviation()+";";
				}
				if(metric instanceof AggregatedRealMetric) {
					body+=((AggregatedRealMetric)metric).getAverage()+";";
					body+=((AggregatedRealMetric)metric).getMaximum()+";";
					body+=((AggregatedRealMetric)metric).getMedian()+";";
					body+=((AggregatedRealMetric)metric).getMinimum()+";";
					body+=((AggregatedRealMetric)metric).getStandardDeviation()+";";
				}
				if(metric instanceof SimpleMetric) {
					body+=((SimpleMetric)metric).getValue()+";";
				}
			}
			out.println(body);
		}
		out.close();
		((ConfigurableApplicationContext)context).close();
	}
}
