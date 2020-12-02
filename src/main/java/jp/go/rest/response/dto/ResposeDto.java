package jp.go.rest.response.dto;

import java.util.List;

public class ResposeDto {

	public String val1;
	public int val2;

	public List<Members> members;
//	public List<Members> members = new ArrayList<Members>();

	public List<Members> getMembers() {
		return members;
	}

	public void setMembers(List<Members> members) {
		this.members = members;
	}

	public int getVal2() {
		return val2;
	}

	public void setVal2(int val2) {
		this.val2 = val2;
	}

	public String getVal() {
		return val1;
	}

	public void setVal(String val) {
		this.val1 = val;
	}

	public static class Members {

		public String name;
		public int age;
		public String secretIdentity;

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

		public String getSecretIdentity() {
			return secretIdentity;
		}

		public void setSecretIdentity(String secretIdentity) {
			this.secretIdentity = secretIdentity;
		}

	}

}
