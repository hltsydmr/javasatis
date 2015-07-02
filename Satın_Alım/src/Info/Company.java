package Info;

public class Company {

	private String companyId;
	private String companyName;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getcompanyName() {
		return companyName;
	}
	public void setcompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Company(String companyId,String companyName){
		this.companyId=companyId;
		this.companyName=companyName;
	}
	public String toString() {
		return companyName +" - "+companyId;
	}
	
	
}
