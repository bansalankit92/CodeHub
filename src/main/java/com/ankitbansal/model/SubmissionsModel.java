package com.ankitbansal.model;

public class SubmissionsModel {
	long submision_id;
	String title;
	String metadata;
	String source;
	String status,language;
	public long getSubmision_id() {
		return submision_id;
	}
	public void setSubmision_id(long submision_id) {
		this.submision_id = submision_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "SubmissionsModel [submision_id=" + submision_id + ", title="
				+ title + ", metadata=" + metadata + ", source=" + source
				+ ", status=" + status + ", language=" + language + "]";
	}
	public SubmissionsModel(long submision_id, String title, String metadata,
			String source, String status, String language) {
		super();
		this.submision_id = submision_id;
		this.title = title;
		this.metadata = metadata;
		this.source = source;
		this.status = status;
		this.language = language;
	}
	public SubmissionsModel(){
		
	}
	
	
}
