package Model;

public class benhAnVIP extends benhAn {
	private String typeVIP;
	private String dateVIP;

	public String getTypeVIP() {
		return typeVIP;
	}
	public void setTypeVIP(String typeVIP) {
		this.typeVIP = typeVIP;
	}
	public String getDateVIP() {
		return dateVIP;
	}
	public void setDateVIP(String dateVIP) {
		this.dateVIP = dateVIP;
	}
	@Override
	public String toString() {
		return super.toString() + " [typeVIP=" + typeVIP + ", dateVIP=" + dateVIP + "]";
	}
	
}
