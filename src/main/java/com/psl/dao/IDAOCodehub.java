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
	List<SubmissionsModel> getSearchResultsFiltered(String  query,String filter,int page);
	 List<SubmissionsModel> getSearchResultsFilteredAdv(String query,
			String filter1,String filter2, int page);
	
	
	
}
