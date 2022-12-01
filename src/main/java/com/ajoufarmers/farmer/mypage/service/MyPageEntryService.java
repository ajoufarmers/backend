package com.ajoufarmers.farmer.mypage.service;

import com.ajoufarmers.farmer.mypage.dto.MyPageEntryDto;
import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import com.ajoufarmers.farmer.mypage.repository.MyPageEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyPageEntryService {
    private final MyPageEntryRepository myPageEntryRepository;

    @Autowired
    public MyPageEntryService(MyPageEntryRepository myPageEntryRepository) {
        this.myPageEntryRepository = myPageEntryRepository;
    }

    public MyPageEntryDto saveMyPlant(MyPageEntryDto myPageEntryDto) {
        return myPageEntryRepository.save(myPageEntryDto.toEntity()).toDto();
    }

    public List<MyPageEntryDto> findMyPlants(Long memberId) {
        return myPageEntryRepository.findByMemberId(memberId).stream().map(
                MyPageEntry::toDto).collect(Collectors.toList());
    }

    public Optional<MyPageEntryDto> findOne(Long plantId) {
        return Optional.ofNullable(myPageEntryRepository.findById(plantId).get().toDto());
    }

    public MyPageEntryDto updateMyPlant(MyPageEntryDto myPageEntryDto) {
        return myPageEntryRepository.save(myPageEntryDto.toEntity()).toDto();
    }

    public void deleteMyPlant(Long plantId){
        myPageEntryRepository.deleteById(plantId);
    }
}
