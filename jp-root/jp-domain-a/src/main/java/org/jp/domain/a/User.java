package org.jp.domain.a;

import java.util.Calendar;

public class User {
private String name;
private int age;
private Calendar birthDay  = Calendar.getInstance();
private String birthDayStr = Calendar.getInstance().toString() ;

public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}
public Calendar getCreated() {
		return this.birthDay;
	}

	public void setCreated(Calendar birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthDayStr() {
		return this.birthDay.toString();
	}

	public void setBirthDayStr(Calendar birthDay) {
		this.birthDayStr = this.birthDay.toString();
	}
	
public User(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
public User(){}
}