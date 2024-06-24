package Mapper;

import java.util.StringTokenizer;

public interface IRowMapper<T> {
	T rowMapper(StringTokenizer st);
}
