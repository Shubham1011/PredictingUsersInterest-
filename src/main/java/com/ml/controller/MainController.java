package com.ml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ml.App;
import com.ml.model.Attribute;
import com.ml.model.InterestList;
import com.ml.service.NaiveBayesianClassifier;

@RestController
public class MainController {

	@Autowired
	NaiveBayesianClassifier nbc;
	
	
	
	@PostMapping("/trainmodel")
	public List<InterestList> classify(@RequestBody Attribute at) throws Exception
	{
	
	
		String list=null;		
		for(int i=0;i<2;i++)
		{
		list=nbc.trainmodelandclassify(at);
		}
		if(list.equals("list1"))
			return App.list1;
		if(list.equals("list2"))
			return App.list2;
		else
			return App.list3;
		
		
	
	}
}
