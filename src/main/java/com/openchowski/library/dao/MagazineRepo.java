package com.openchowski.library.dao;

import com.openchowski.library.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepo extends JpaRepository<Magazine, Integer> {
}
