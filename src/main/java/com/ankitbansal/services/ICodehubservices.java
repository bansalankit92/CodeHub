package com.ankitbansal.services;

import java.util.List;
import java.util.Map;

import com.ankitbansal.model.SubmissionsModel;

public interface ICodehubservices {
	List<SubmissionsModel> getSubmissions(int page);

	List<SubmissionsModel> getSearchResult(String  query,int page);
	Map<String ,Integer> getTop5Lang();
	Map<String ,Integer> getTop2Submissions();
	int getTotalSubmissions();
	Map<String ,Integer> getSubmissionsPerLevel();
	List<SubmissionsModel> getSearchResultsFiltered(String  query,List<String>filter,int page);

}
