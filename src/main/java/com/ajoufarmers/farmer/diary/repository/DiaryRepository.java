package com.ajoufarmers.farmer.diary.repository;

import com.ajoufarmers.farmer.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByMemberId(Long memberId);
}
