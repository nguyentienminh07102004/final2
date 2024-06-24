package Repository;

import java.util.List;

import Model.benhAn;

public interface IBenhAn {
	List<benhAn> findAll();
	void insert(benhAn ba);
	void delete(String id);
}
