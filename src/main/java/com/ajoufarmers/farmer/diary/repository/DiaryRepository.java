package com.ajoufarmers.farmer.diary.repository;

import com.ajoufarmers.farmer.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
