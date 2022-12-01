package com.ajoufarmers.farmer.mypage.repository;

import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MyPageEntryRepository extends JpaRepository<MyPageEntry, Long> {
    MyPageEntry save(MyPageEntry myPageEntry);
    List<MyPageEntry> findByMemberId(Long memberId);
    Optional<MyPageEntry> findById(Long id);
    void deleteById(Long id);
}