package Mapper.IMPL;

import java.util.StringTokenizer;

import Model.benhAn;
import Model.benhAnVIP;

public class benhAnVipMapper extends benhAnMapper {
	@Override
	public benhAn rowMapper(StringTokenizer st) {
		benhAn ba = super.rowMapper(st);
		benhAnVIP bav = (benhAnVIP)ba;
		bav.setTypeVIP(st.nextToken());
		bav.setDateVIP(st.nextToken());
		return bav;
	}
}
