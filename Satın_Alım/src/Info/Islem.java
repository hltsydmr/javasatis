package Info;

public class Islem {

	private int islemNo;
	private String tarih;
	private String companyName;
	private int companyId;
	private float  tutar;
	private String username;
	private String not;
	private String islemTipi;
	
	public int getIslemNo() {
		return islemNo;
	}
	public void setIslemNo(int islemNo) {
		this.islemNo = islemNo;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public float getTutar() {
		return tutar;
	}
	public void setTutar(float tutar) {
		this.tutar = tutar;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNot() {
		return not;
	}
	public void setNot(String not) {
		this.not = not;
	}
	public String getIslemTipi() {
		return islemTipi;
	}
	public void setIslemTipi(String islemTipi) {
		this.islemTipi = islemTipi;
	}
	
	public Islem(int islemNo,String tarih,String companyName,int companyId,float tutar,String username,String not,String islemTipi){
		this.islemNo = islemNo;
		this.tarih = tarih;
		this.companyName = companyName;
		this.companyId = companyId;
		this.tutar = tutar;
		this.username = username;
		this.not = not;
		this.islemTipi = islemTipi;
	}
}
