package cn.ekgc.spring.d0828.ioc;

import java.util.List;
import java.util.Map;
import java.util.Set;
public class User {
	private String name;
	private Integer age;
	private List<String> cityList;
	private Map<String, String> nameMap;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("name = " + name);
		System.out.println("gender = " + age);
		for (String city : cityList) {
			System.out.println(city);
		}

		Set<String> keySet = nameMap.keySet();
		for (String key : keySet) {
			System.out.println(key + "\t" + nameMap.get(key));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public Map<String, String> getNameMap() {
		return nameMap;
	}

	public void setNameMap(Map<String, String> nameMap) {
		this.nameMap = nameMap;
	}
}
