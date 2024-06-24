package Validate;

import java.util.regex.Pattern;

import ExceptionHandler.DuplicateMedicalRecordException;
import Repository.IMPL.BenhAn;

public class validate {

	public static Boolean checkMa(String id) {
		String regex = "B[N|A]-[0-9]{3}";
		return Pattern.matches(regex, id);
	}

	public static Boolean checkTypeVIP(String typeVIP) {
		String regex = "VIP [I]{1, 3}";
		return Pattern.matches(regex, typeVIP);
	}

	public static void checkMaBA(String maBA) {
		if((new BenhAn()).findAll().stream().filter(item -> item.getMaBA() == maBA).toArray().length > 0) {
			throw new DuplicateMedicalRecordException("Benh an da ton tai");
		}
	}
}
