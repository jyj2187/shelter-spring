package kr.co.llems.shelterspring.song.service;

import kr.co.llems.shelterspring.song.dto.SongDto;
import kr.co.llems.shelterspring.util.dto.MultiResponseDto;
import org.springframework.data.domain.PageRequest;

public interface SongService {
    SongDto.Response createSong(SongDto.Post postDto);

    SongDto.Response readSong(Long songId);

    MultiResponseDto readAllSong(PageRequest pageRequest);

    SongDto.Response patchSong(Long songId, SongDto.Patch patchDto);

    void deleteSong(Long songId);
}
