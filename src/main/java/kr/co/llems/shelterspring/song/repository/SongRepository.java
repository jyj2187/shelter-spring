package kr.co.llems.shelterspring.song.repository;

import kr.co.llems.shelterspring.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
