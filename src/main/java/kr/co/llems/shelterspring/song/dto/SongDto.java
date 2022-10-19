package kr.co.llems.shelterspring.song.dto;

import kr.co.llems.shelterspring.song.entity.Song;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class SongDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Post{
        private String title;
        private String description;
        private String lyric;

        @Builder
        public Post(String title, String description, String lyric) {
            this.title = title;
            this.description = description;
            this.lyric = lyric;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Patch{
        private String title;
        private String description;
        private String lyric;

        @Builder
        public Patch(String title, String description, String lyric) {
            this.title = title;
            this.description = description;
            this.lyric = lyric;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response{
        private Long songId;
        private String title;
        private String description;
        private String lyric;
        private Song.SongStatus songStatus;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        @Builder
        public Response(Long songId, String title, String description, String lyric, Song.SongStatus songStatus, LocalDateTime createdAt, LocalDateTime modifiedAt) {
            this.songId = songId;
            this.title = title;
            this.description = description;
            this.lyric = lyric;
            this.songStatus = songStatus;
            this.createdAt = createdAt;
            this.modifiedAt = modifiedAt;
        }
    }
}
