package com.bhavna.employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeData {

	List<Employee> list;
	
	{
		 list=new ArrayList<>();
		 list.add(new Employee("naraka", 100002, "pune"));
		 list.add(new Employee("satish", 100000, "hyderabad"));
		 list.add(new Employee("sravan", 99999, "banglore"));
		 list.add(new Employee("srikanth", 100001, "hyderabad"));
		 list.add(new Employee("ragul", 100001, "kolkata"));
		 list.add(new Employee("mallu", 99999, "hyderabad"));
	}
	
	public void getAll() {
	System.out.println(list);
	}
	
	public void getNameStartsWithS() {
		Long sCount=list.stream().map(s->s.getName()).filter(s->s.startsWith("s")).count();
		System.out.println(sCount);
	}
	
	public void parallelLocationHyderabad() {
		list.parallelStream().filter(s->s.getLocation().equals("hyderabad")).forEach(s->System.out.println(s));
	}
	
	public void getDataInMap() {
		
		Map<String, List<Employee>> emp=list.stream().collect(Collectors.groupingBy(Employee::getLocation));
		
		emp.forEach((key,value)->{
			System.out.println(key);
			System.out.println("-----------");
			System.out.println(value);
			System.out.println("\n");
		});
		
		
		//**this is the another way to store the data in map

//		Map<String, List<Employee>> map1=new HashMap<>();
//		
//		list.stream().map(s->s.getLocation()).distinct()
//		.forEach(s->{
//			list.stream().filter(g->g.getLocation().equals(s))
//			.forEach(d->{
//				if(map1.containsKey(s)) {
//					List<Employee> e1=map1.get(s);
//					e1.add(d);
//					map1.put(s, e1);
//				}else {
//					List<Employee> e2=new ArrayList<>();
//					e2.add(d);
//					map1.put(s, e2);
//				}
//			});
//		});
//		
//		map1.forEach((key,value)->{
//			System.out.println(key);
//			System.out.println("-----------");
//			System.out.println(value);
//			System.out.println("\n");
//		});
//		
	}
	
	public void salGreaterthanOneLakh() {
		list.stream().filter(s->s.getSalary()>100000).forEach(s->System.out.println(s));
	}
	
	public void sortingLogic() {
		list.sort((e1,e2)->e1.getName().compareTo(e2.getName()));
		System.out.println("sort by name");System.out.println("-------------");
		list.forEach(s->System.out.println(s));
		
		list.sort((e1,e2)->e1.getLocation().compareTo(e2.getLocation()));
		System.out.println("\nsort by location");System.out.println("-------------");
		list.forEach(s->System.out.println(s));
	}
}



