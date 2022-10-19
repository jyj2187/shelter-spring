package kr.co.llems.shelterspring.util.dto;

import kr.co.llems.shelterspring.song.dto.SongDto;
import kr.co.llems.shelterspring.song.entity.Song;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto<T> {
    private List<T> data;
    private PageInfo pageInfo;

    public MultiResponseDto(List<T> data, Page<T> page) {
        this.data = data;
        this.pageInfo = new PageInfo(page);
    }
}
