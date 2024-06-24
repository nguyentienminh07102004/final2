package Mapper.IMPL;

import java.util.StringTokenizer;

import Mapper.IRowMapper;
import Model.benhAn;

public class benhAnMapper implements IRowMapper<benhAn> {

	@Override
	public benhAn rowMapper(StringTokenizer st) {
		benhAn ba = new benhAn();
		ba.setSTT(Long.parseLong(st.nextToken()));
		ba.setMaBA(st.nextToken());
		ba.setMaBN(st.nextToken());
		ba.setTen(st.nextToken());
		ba.setNgayVao(st.nextToken());
		ba.setNgayRa(st.nextToken());
		ba.setLyDo(st.nextToken());
		return ba;
	}

}
