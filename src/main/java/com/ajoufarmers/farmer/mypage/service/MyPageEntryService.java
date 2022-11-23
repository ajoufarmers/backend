package com.ajoufarmers.farmer.mypage.service;

import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import com.ajoufarmers.farmer.mypage.repository.MyPageEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyPageEntryService {
    private final MyPageEntryRepository myPageEntryRepository;

    @Autowired
    public MyPageEntryService(MyPageEntryRepository myPageEntryRepository) {
        this.myPageEntryRepository = myPageEntryRepository;
    }

    public MyPageEntry saveMyPlant(MyPageEntry myPageEntry) {
        return myPageEntryRepository.save(myPageEntry);
    }

    public List<MyPageEntry> findMyPlants(Long memberId) {
        return myPageEntryRepository.findByMemberId(memberId);
    }

    public Optional<MyPageEntry> findOne(Long plantId) {
        return myPageEntryRepository.findById(plantId);
    }

    public MyPageEntry updateMyPlant(MyPageEntry myPageEntry) {
        return myPageEntryRepository.save(myPageEntry);
    }
}
