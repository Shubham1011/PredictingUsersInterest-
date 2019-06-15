package com.ml;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ml.model.InterestList;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@SpringBootApplication
public class App extends SpringBootServletInitializer{

	public static InterestList i1=new InterestList("technology", "/");
	public static InterestList i13=new InterestList("sports", "/");
	public static InterestList i2=new InterestList("music", "/");
	public static InterestList i3=new InterestList("business", "/");
	public static InterestList i4=new InterestList("food", "/");
	public static InterestList i5=new InterestList("politics", "/");
	public static List<InterestList> list1=new ArrayList<>(Arrays.asList(i1,i2,i3,i3,i4));
	public static List<InterestList> list2=new ArrayList<>(Arrays.asList(i3,i5,i2,i1,i4));
	public static List<InterestList> list3=new ArrayList<>(Arrays.asList(i5,i3,i2,i1,i4));
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
		}}


