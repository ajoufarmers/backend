package com.ajoufarmers.farmer.mypage.repository;

import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyPageEntryRepository extends JpaRepository<MyPageEntry, Long> {
    MyPageEntry save(MyPageEntry myPageEntry);

    Optional<MyPageEntry> update(MyPageEntry myPageEntry);

    List<MyPageEntry> findAll();
    Optional<MyPageEntry> findById(Long id);
}