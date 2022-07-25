package com.example.library.repository;

import com.example.library.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    List<Reader> findAllByActive(Integer active);

    Reader findReaderByIdAndActive(Long id, Integer active);

}
