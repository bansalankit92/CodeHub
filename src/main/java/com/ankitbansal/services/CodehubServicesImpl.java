package com.ankitbansal.services;

import java.util.List;
import java.util.Map;

import com.ankitbansal.model.SubmissionsModel;
import com.psl.dao.DAOCodehubImpl;
import com.psl.dao.IDAOCodehub;

public class CodehubServicesImpl implements ICodehubservices {

	IDAOCodehub dao=new DAOCodehubImpl();
	public List<SubmissionsModel> getSearchResult(String query, int page) {
		// TODO Auto-generated method stub
		return dao.getSearchResult(query, page);
	}

	public Map<String, Integer> getTop5Lang() {
		// TODO Auto-generated method stub
		return dao.getTop5Lang();
	}

	public Map<String, Integer> getTop2Submissions() {
		// TODO Auto-generated method stub
		return dao.getTop2Submissions();
	}

	public int getTotalSubmissions() {
		// TODO Auto-generated method stub
		return dao.getTotalSubmissions();
	}

	public Map<String, Integer> getSubmissionsPerLevel() {
		// TODO Auto-generated method stub
		return dao.getSubmissionsPerLevel();
	}

	public List<SubmissionsModel> getSearchResultsFiltered(String query,
			List<String> filter, int page) {
		// TODO Auto-generated method stub
		return dao.getSearchResultsFiltered(query, filter, page);
	}

	public List<SubmissionsModel> getSubmissions(int page) {
		// TODO Auto-generated method stub
		return dao.getSubmissions(page);
	}

}
