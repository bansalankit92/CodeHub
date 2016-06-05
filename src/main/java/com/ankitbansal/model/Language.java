package com.ankitbansal.model;

public class Language {
int id;
String language;
String icon;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
@Override
public String toString() {
	return "Language [id=" + id + ", language=" + language + ", icon=" + icon
			+ "]";
}




}
