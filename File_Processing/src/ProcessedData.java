import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessedData {
	
	Map<String, List<EntityClass>> map=new HashMap<>();
	
	Map<String,List<String>> failureMap=new HashMap<>();
	
	private final String key="FAILURE_DATA";
	
	public void getAllTheData() throws IOException{
		File file=new File("data.txt");
		FileReader fin=new FileReader(file);
		BufferedReader bin=new BufferedReader(fin);
		String str;
		while((str=bin.readLine())!=null) {
			String[] st=str.split("\\n");
			for(String ss:st) {	
				ss=ss.replaceAll("\\s{2,}"," ").trim();
				String[] stdate=ss.split("\\s");
				
				if(stdate[0].matches("^[a-zA-Z]+$") && stdate[1].matches("^[0-1][0-9]/[0-3][0-9]$") && stdate[2].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") && stdate[3].matches("(am|pm|AM|PM)")) {
				
					if(map.containsKey(stdate[0])) {
						List<EntityClass> ec1=map.get(stdate[0]);
						ec1.add(new EntityClass(stdate[0], stdate[1], stdate[2]+" "+stdate[3]));
						map.put(stdate[0], ec1);
					}else {
						List<EntityClass> ec2=new ArrayList<>();
						ec2.add(new EntityClass(stdate[0], stdate[1], stdate[2]+" "+stdate[3]));
						map.put(stdate[0], ec2);
					}
					
				}else {
					List<String> failList=failureMap.getOrDefault(key, new ArrayList<>());
					failList.add(str);
					failureMap.put(key, failList);
				}
			}
		}
	}
	
	public void printAll(){
		for(Map.Entry<String, List<EntityClass>> m:map.entrySet()) {
			String dataKey=m.getKey();
			List<EntityClass> dataList=m.getValue();
			System.out.print(dataKey+" :  " );
			System.out.println(dataList.size());
			System.out.println("---------------");
			System.out.println(dataList);
			System.out.println("\n");

		}
	}
	
	
	public void getByName(String name) throws DetailsCustom {
		if(map.containsKey(name)) {
			System.out.println("no of times logged in : "+map.get(name).size());
			System.out.println(map.get(name));
		}
		else {
			throw new DetailsCustom("the user "+name+" not found here");
		}
	}
	
	public void failedData() {
		System.out.println(failureMap);
	}
}
	

