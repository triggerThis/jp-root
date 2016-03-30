package org.jp.springboot.service;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.jp.domain.a.*;
import org.jp.domain.a.User;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;;


//http://blog.csdn.net/kongzhichen/article/details/10135051
@Service("userService")
public class UserService {
	
public List<User> getList(String sJson){
 User u=new User("",0);
 //改为注入方式，可以少写很多行了
  Gson g=new Gson();
  String s="[{name:'zhangsan',age:12},{name:'lisi',age:12}]";
  //TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。
  Type lt=new TypeToken<List<User>>(){}.getType();
  List<User> l=g.fromJson(s,lt);
  for(User u1:l){
      System.out.println(u1.getName()+"      "+u1.getAge());
  }
  
  return l;
 }
 
public User fromJson (String sJson){
	User u=new User();
    Gson g=new Gson();
    u=g.fromJson("{name:'zhangsan',age:12}", User.class);
    System.out.println(u.getName()+"      "+u.getAge()); 
    return u;
}
 
public String listToJson(){
  List<User> l=new LinkedList<User>();
  User u=new User("zhangsan",19);
  l.add(u);
  User u2=new User("zhangsan2",19);
  l.add(u2);
  Gson g=new Gson();
  System.out.println(g.toJson(l));
  return g.toJson(l);
 }
 
public String toJson(){ 
	User u=new User("zhangsan",19);
	Gson g=new Gson();
	System.out.println(g.toJson(u));
	return g.toJson(u);
}

//��ӡ�����{"name":"zhangsan","age":19}
}