package com.ankitbansal.output;

import java.util.List;
import java.util.Map;

import com.ankitbansal.model.SubmissionsModel;
import com.ankitbansal.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class AnalyticsResponseBody {
	@JsonView(Views.Public.class)
	Map<String,Integer> top_5_languages_used;
	
	@JsonView(Views.Public.class)
	Map<String,Integer> top_2_submissions_attempted;
	
	@JsonView(Views.Public.class)
	Map<String,Integer> submissions_per_level;
	
	@JsonView(Views.Public.class)
	int total_submissions;

	public Map<String, Integer> getTop_5_languages_used() {
		return top_5_languages_used;
	}

	public void setTop_5_languages_used(Map<String, Integer> top_5_languages_used) {
		this.top_5_languages_used = top_5_languages_used;
	}

	public Map<String, Integer> getTop_2_submissions_attempted() {
		return top_2_submissions_attempted;
	}

	public void setTop_2_submissions_attempted(
			Map<String, Integer> top_2_submissions_attempted) {
		this.top_2_submissions_attempted = top_2_submissions_attempted;
	}

	public Map<String, Integer> getSubmissions_per_level() {
		return submissions_per_level;
	}

	public void setSubmissions_per_level(Map<String, Integer> submissions_per_level) {
		this.submissions_per_level = submissions_per_level;
	}

	public int getTotal_submissions() {
		return total_submissions;
	}

	public void setTotal_submissions(int total_submissions) {
		this.total_submissions = total_submissions;
	}

}
