package Model;

public class benhAn {
	private Long STT;
	private String maBA;
	private String maBN;
	private String ten;
	private String ngayVao;
	private String ngayRa;
	private String lyDo;

	public Long getSTT() {
		return STT;
	}
	public void setSTT(Long sTT) {
		STT = sTT;
	}
	public String getMaBA() {
		return maBA;
	}
	public void setMaBA(String maBA) {
		this.maBA = maBA;
	}
	public String getMaBN() {
		return maBN;
	}
	public void setMaBN(String maBN) {
		this.maBN = maBN;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgayVao() {
		return ngayVao;
	}
	public void setNgayVao(String ngayVao) {
		this.ngayVao = ngayVao;
	}
	public String getNgayRa() {
		return ngayRa;
	}
	public void setNgayRa(String ngayRa) {
		this.ngayRa = ngayRa;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	@Override
	public String toString() {
		return "benhAn [STT=" + STT + ", maBA=" + maBA + ", maBN=" + maBN + ", ten=" + ten + ", ngayVao=" + ngayVao
				+ ", ngayRa=" + ngayRa + ", lyDo=" + lyDo + "]";
	}
}
