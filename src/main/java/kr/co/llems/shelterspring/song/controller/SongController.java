package kr.co.llems.shelterspring.song.controller;

import kr.co.llems.shelterspring.song.dto.SongDto;
import kr.co.llems.shelterspring.song.service.SongService;
import kr.co.llems.shelterspring.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/songs")
@RestController
public class SongController {
    private final SongService songService;

    @PostMapping
    public ResponseEntity postSong(@RequestBody SongDto.Post postDto) {
        SongDto.Response responseDto = songService.createSong(postDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{song-id}")
    public ResponseEntity getSong(@PathVariable("song-id") Long songId) {
        SongDto.Response responseDto = songService.readSong(songId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllSong(@PageableDefault(page = 1, sort = "songId", direction = Sort.Direction.DESC)
                                     Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(), pageable.getSort());
        MultiResponseDto responseDto = songService.readAllSong(pageRequest);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    @PatchMapping("/{song-id}")
    public ResponseEntity patchSong(@PathVariable("song-id") Long songId,
                                    @RequestBody SongDto.Patch patchDto) {
        SongDto.Response responseDto = songService.patchSong(songId, patchDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{song-id}")
    public ResponseEntity deleteSong(@PathVariable("song-id") Long songId) {
        songService.deleteSong(songId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
