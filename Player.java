package com.mphasis.player.beans;

import java.util.Date;

public class Player {
private int pid;
private String name;
private String gender;
private long contact;
private String email;
private Date dob;
private long score;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTeamname() {
	return teamname;
}
public void setTeamname(String teamname) {
	this.teamname = teamname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public long getScore() {
	return score;
}
public void setScore(long score) {
	this.score = score;
}
private String teamname;
private int age;
@Override
public String toString() {
	return "Player [pid=" + pid + ", name=" + name + ", gender=" + gender + ", contact=" + contact + ", email=" + email
			+ ", teamname=" + teamname + ", age=" + age + ", dob=" + dob + ", score=" + score + "]";
}

}
