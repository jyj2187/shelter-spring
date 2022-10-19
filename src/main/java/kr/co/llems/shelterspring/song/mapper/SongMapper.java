package kr.co.llems.shelterspring.song.mapper;

import kr.co.llems.shelterspring.song.dto.SongDto;
import kr.co.llems.shelterspring.song.entity.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {
    Song postToSong(SongDto.Post postDto);
    SongDto.Response songToResponse(Song song);
    List<SongDto.Response> songListToResponseList(List<Song> songList);
}
