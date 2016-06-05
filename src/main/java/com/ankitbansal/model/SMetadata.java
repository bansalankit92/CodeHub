package com.ankitbansal.model;

public class SMetadata {
	private levels levell;
	int rating;
	long users_attempted;
	public levels getLevell() {
		return levell;
	}
	public void setLevell(levels levell) {
		this.levell = levell;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public long getUsers_attempted() {
		return users_attempted;
	}
	public void setUsers_attempted(long users_attempted) {
		this.users_attempted = users_attempted;
	}
	@Override
	public String toString() {
		return "Metadata [levell=" + levell + ", rating=" + rating
				+ ", users_attempted=" + users_attempted + "]";
	}
	
	
}
