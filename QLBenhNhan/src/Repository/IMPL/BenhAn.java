package Repository.IMPL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import Mapper.IMPL.benhAnMapper;
import Model.benhAn;
import Model.benhAnThuong;
import Model.benhAnVIP;
import Repository.IBenhAn;

public class BenhAn implements IBenhAn {

	@Override
	public List<benhAn> findAll() {
		List<benhAn> result = new ArrayList<>();
		File file = new File("src\\Data\\medical_records.csv");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				benhAn ba = new benhAnMapper().rowMapper(st);
				String type = st.nextToken();
				if(!type.trim().startsWith("VIP")) {
					benhAnThuong  bat = new benhAnThuong();
					bat.setSTT(ba.getSTT());
					bat.setMaBA(ba.getMaBA());
					bat.setMaBN(ba.getMaBN());
					bat.setTen(ba.getTen());
					bat.setNgayVao(ba.getNgayVao());
					bat.setNgayRa(ba.getNgayRa());
					bat.setLyDo(ba.getLyDo());
					bat.setPhi(Double.parseDouble(type));
					result.add(bat);
				} else {
					benhAnVIP bav = new benhAnVIP();
					bav.setSTT(ba.getSTT());
					bav.setMaBA(ba.getMaBA());
					bav.setMaBN(ba.getMaBN());
					bav.setTen(ba.getTen());
					bav.setNgayVao(ba.getNgayVao());
					bav.setNgayRa(ba.getNgayRa());
					bav.setLyDo(ba.getLyDo());
					bav.setTypeVIP(type);
					bav.setDateVIP(st.nextToken());
					result.add(bav);
				}
				line = bufferedReader.readLine();
			}
			return result;
		} catch (Exception e) {
			return null;
		} finally {
			try{
				if(bufferedReader != null) bufferedReader.close();
				if(fileReader != null) fileReader.close();
			} catch (IOException ex) {

			}
		}
		
	}

	@Override
	public void insert(benhAn ba) {
		File file = new File("src\\Data\\medical_records.csv");
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.newLine();
			String b = ba.getSTT() + ", " + ba.getMaBA() + ", " + ba.getMaBN() + ", " + ba.getTen() + ", " + ba.getNgayVao()
						+ ", " + ba.getNgayRa() + ", " + ba.getLyDo() + ", ";
			if(ba instanceof benhAnThuong) {
				b += ((benhAnThuong)ba).getPhi();
			} else {
				b += ((benhAnVIP)ba).getTypeVIP() + ", " + ((benhAnVIP)ba).getDateVIP();
			}
			bufferedWriter.append(b);
		} catch (Exception e) {
			
		} finally {
			try{
				if(bufferedWriter != null) bufferedWriter.close();
				if(fileWriter != null) fileWriter.close();
			} catch (IOException ex) {

			}
		}
		
	}

	@Override
	public void delete(String id) {
		File file = new File("src\\Data\\medical_records.csv");
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<benhAn> result = new ArrayList<>();
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				benhAn ba = new benhAnMapper().rowMapper(st);
				String type = st.nextToken();
				if(!type.trim().startsWith("VIP")) {
					benhAnThuong  bat = new benhAnThuong();
					bat.setSTT(ba.getSTT());
					bat.setMaBA(ba.getMaBA());
					bat.setMaBN(ba.getMaBN());
					bat.setTen(ba.getTen());
					bat.setNgayVao(ba.getNgayVao());
					bat.setNgayRa(ba.getNgayRa());
					bat.setLyDo(ba.getLyDo());
					bat.setPhi(Double.parseDouble(type));
					result.add(bat);
				} else {
					benhAnVIP bav = new benhAnVIP();
					bav.setSTT(ba.getSTT());
					bav.setMaBA(ba.getMaBA());
					bav.setMaBN(ba.getMaBN());
					bav.setTen(ba.getTen());
					bav.setNgayVao(ba.getNgayVao());
					bav.setNgayRa(ba.getNgayRa());
					bav.setLyDo(ba.getLyDo());
					bav.setTypeVIP(type);
					bav.setDateVIP(st.nextToken());
					result.add(bav);
				}
				line = bufferedReader.readLine();
			}
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			for(benhAn ba : result){
				if(ba.getMaBA().equals(id)) continue;
				String b = ba.getSTT() + ", " + ba.getMaBA() + ", " + ba.getMaBN() + ", " + ba.getTen() + ba.getNgayVao()
							+ ", " + ba.getNgayRa() + ", " + ba.getLyDo() + ", ";
				if(ba instanceof benhAnThuong) {
					b += ((benhAnThuong)ba).getPhi();
				} else {
					b += ((benhAnVIP)ba).getTypeVIP() + ", " + ((benhAnVIP)ba).getDateVIP();
				}
				bufferedWriter.write(b);
				bufferedWriter.newLine();
			}
		} catch (Exception e) {
			
		} finally {
			try{
				if(bufferedWriter != null) bufferedWriter.close();
				if(fileWriter != null) fileWriter.close();
				if(fileReader != null) fileReader.close();
				if(bufferedReader != null) bufferedReader.close();
			} catch (IOException ex) {

			}
		}
	}

}
