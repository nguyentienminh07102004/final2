package Mapper.IMPL;

import java.util.StringTokenizer;

import Model.benhAn;
import Model.benhAnThuong;

public class benhAnThuongMapper extends benhAnMapper {
	@Override
	public benhAn rowMapper(StringTokenizer st) {
		benhAn ba = super.rowMapper(st);
		benhAnThuong bat = (benhAnThuong)ba;
		bat.setPhi(Double.valueOf(st.nextToken()));
		return bat;
	}
}
