package com.ajoufarmers.farmer.diary.repository;

import com.ajoufarmers.farmer.diary.entity.Diary;
import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByMemberId(Long memberId);

    Optional<Diary> findById(Long id);

    Diary save(Diary diary);

}
