package kr.co.llems.shelterspring.song.service;

import kr.co.llems.shelterspring.song.dto.SongDto;
import kr.co.llems.shelterspring.song.entity.Song;
import kr.co.llems.shelterspring.song.mapper.SongMapper;
import kr.co.llems.shelterspring.song.repository.SongRepository;
import kr.co.llems.shelterspring.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final SongMapper songMapper;
    @Override
    public SongDto.Response createSong(SongDto.Post postDto) {
        Song song = songMapper.postToSong(postDto);
        songRepository.save(song);
        return songMapper.songToResponse(song);
    }

    @Override
    public SongDto.Response readSong(Long songId) {
        Song song = findVerifiedSong(songId);
        return songMapper.songToResponse(song);
    }

    @Override
    public MultiResponseDto readAllSong(PageRequest pageRequest) {
        Page<Song> songPage = songRepository.findAll(pageRequest);
        List<Song> songList = songPage.getContent();
        return new MultiResponseDto(songMapper.songListToResponseList(songList), songPage);
    }

    @Override
    public SongDto.Response patchSong(Long songId, SongDto.Patch patchDto) {
        Song song = findVerifiedSong(songId);
        song.update(patchDto);
        songRepository.save(song);
        return songMapper.songToResponse(song);
    }

    @Override
    public void deleteSong(Long songId) {
        Song song = findVerifiedSong(songId);
        song.inactive();
    }

    public Song findVerifiedSong(Long songId) {
        return songRepository.findById(songId).orElseThrow();
    }
}
