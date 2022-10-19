package kr.co.llems.shelterspring.song.entity;

import kr.co.llems.shelterspring.song.dto.SongDto;
import kr.co.llems.shelterspring.util.audit.Auditable;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Song extends Auditable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    // TODO: 객체로 받을 것. -> Entity? or Embedded?
    private String title;
    private String description;
    private String lyric;
    @Enumerated(EnumType.STRING)
    private SongStatus songStatus;

//    private Artist artist;

    @Builder
    public Song(Long songId, String title, String description, String lyric, SongStatus songStatus) {
        this.songId = songId;
        this.title = title;
        this.description = description;
        this.lyric = lyric;
        this.songStatus = songStatus;
    }

    public enum SongStatus {
        INACTIVE(0, "비활성화"),
        NO_ANNOTATION(1, "주석 없음"),
        ACTIVE(2, "활성화");

        int stepNumber;
        String status;

        SongStatus(int stepNumber, String status) {
            this.stepNumber = stepNumber;
            this.status = status;
        }
    }

    public void update(SongDto.Patch patchDto) {
        this.title = patchDto.getTitle();
        this.description = patchDto.getDescription();
        this.lyric = patchDto.getLyric();
    }

    public void inactive() {
        this.songStatus = SongStatus.INACTIVE;
    }
}
