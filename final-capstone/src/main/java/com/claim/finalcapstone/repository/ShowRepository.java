package com.claim.finalcapstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.finalcapstone.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
//	@Query(value = "SELECT s FROM Shows s WHERE s.name LIKE '%' || :keyword || '%'"
//			+ " OR s.demo LIKE '%' || :keyword || '%'"
//			+ " OR s.genre LIKE '%' || :keyword || '%'"
//			+ " OR s.studio LIKE '%' || :keyword || '%'"
//			+ " OR s.year LIKE '%' || :keyword || '%'")
//	public List<Show> search(@Param("keyword") String keyword);

}
