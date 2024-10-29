package domain;

public class User {
	private Integer id;
	private String name;
	private String sex;
	private String hobbys;
	private String info;
	private String job;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobbys() {
		return hobbys;
	}
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "User [hobbys=" + hobbys + ", id=" + id + ", info=" + info
				+ ", job=" + job + ", name=" + name + ",sex=" + sex + "]";
	}
	public User() {
		super();
	}
	public User(Integer id, String name,String sex, String hobbys, String info, String job) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.hobbys = hobbys;
		this.info = info;
		this.job = job;
	}
}
