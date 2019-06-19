package com.ml.service;

import java.io.Console;
import java.io.FileWriter;

import org.springframework.stereotype.Service;

import com.ml.model.Attribute;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
@Service
public class NaiveBayesianClassifier {
	public String trainmodelandclassify(Attribute at) throws Exception {
//converting the age to respective age groups
		if(at.getAge()>=15 && at.getAge()<=25)
			at.setAgegroup("15-25");
		if(at.getAge()>=26 && at.getAge()<=45)
			at.setAgegroup("25-45");
		if(at.getAge()>=46 && at.getAge()<=65)
			at.setAgegroup("45-65");
		
		
		
		//loading the training dataset
	
	DataSource source=new DataSource("enter the location of your .arff file for training data");
	System.out.println(source);
	Instances traindataset=source.getDataSet();
	//setting the class index (which would be one less than the number of attributes)
	traindataset.setClassIndex(traindataset.numAttributes()-1);
	int numclasses=traindataset.numClasses();
    for (int i = 0; i < numclasses; i++) {
    	String classvalue=traindataset.classAttribute().value(i);
    	System.out.println(classvalue);
		
	}
    //building the classifier
    NaiveBayes nb= new NaiveBayes();
    nb.buildClassifier(traindataset);
    System.out.println("model trained successfully");
    
    //test the model
	DataSource testsource=new DataSource("enter the location of your .arff file for test data");
	Instances testdataset=testsource.getDataSet();
	
	FileWriter fwriter = new FileWriter("enter the location of your .arff file for test data",true); //true will append the new instance
	fwriter.write(System.lineSeparator());
	fwriter.write(at.getAgegroup()+","+at.getGender()+","+at.getProfession()+","+"?");//appends the string to the file
	fwriter.close();
	testdataset.setClassIndex(testdataset.numAttributes()-1);
	//looping through the test dataset and making predictions
	for (int i = 0; i < testdataset.numInstances(); i++) {
		double classvalue=testdataset.instance(i).classValue();
		String actualclass=testdataset.classAttribute().value((int)classvalue);
		Instance instance=testdataset.instance(i);
		double pclassvalue=nb.classifyInstance(instance);
		String pclass=testdataset.classAttribute().value((int)pclassvalue);
		System.out.println(actualclass+" "+ pclass);
	
}
	double classval=testdataset.instance(testdataset.numInstances()-1).classValue();
	Instance ins=testdataset.lastInstance();
	double pclassval=nb.classifyInstance(ins);
	String pclass=testdataset.classAttribute().value((int)pclassval);
	System.out.println(pclass);
	
	return pclass;
}
}