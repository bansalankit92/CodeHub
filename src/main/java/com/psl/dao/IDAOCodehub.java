package com.psl.dao;

import java.util.*;

import com.ankitbansal.model.SubmissionsModel;

public interface IDAOCodehub {
	List<SubmissionsModel> getSubmissions(int page);
	List<SubmissionsModel> getSearchResult(String  query,int page);
	Map<String ,Integer> getTop5Lang();
	Map<String ,Integer> getTop2Submissions();
	int getTotalSubmissions();
	Map<String ,Integer> getSubmissionsPerLevel();
	List<SubmissionsModel> getSearchResultsFiltered(String  query,List<String>filter,int page);

	
	
	
}
