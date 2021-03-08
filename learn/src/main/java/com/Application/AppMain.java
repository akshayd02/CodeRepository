package com.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Employee;

public class AppMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Employee employee = new Employee();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Enter ID: ");
			String id  = br.readLine();
			employee.setId(id);
			System.out.println("Enter Username:  ");
			String username = br.readLine();
			employee.setUsername(username);
			System.out.println("Enter Password: ");
			String password = br.readLine();
			employee.setPassword(password);
			System.out.println(employee.getId()+"\t\t"+employee.getPassword()+"\t\t"+employee.getUsername());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp.getId()+"\t\t"+emp.getPassword()+"\t\t"+emp.getUsername());
		if(emp.getPassword().equals(employee.getPassword())) {
			System.out.println("TRUEEEEEEEEEEEEEE");
		}
	}

}
