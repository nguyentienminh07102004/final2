package Model;

public class benhAnThuong extends benhAn {
	private Double phi;

	public Double getPhi() {
		return phi;
	}

	public void setPhi(Double phi) {
		this.phi = phi;
	}

	@Override
	public String toString() {
		return super.toString() + " [phi=" + phi + "]";
	}

}
