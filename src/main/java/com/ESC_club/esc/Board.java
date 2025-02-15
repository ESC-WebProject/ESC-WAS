package com.ESC_club.esc;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long boardId; // 게시글의 고유 ID (자동 증가)

    @ManyToOne // 다대일 관계 (게시글 여러 개가 하나의 회원에게 속함)
    @JoinColumn( nullable = false)
    private Member student; // 회원 테이블과 연결된 외래 키

    @Column( nullable = false, length = 50)
    private String boardCategory; // 게시글의 카테고리 (예: 공지사항, 자유게시판 등)

    @Column( nullable = false, length = 255)
    private String boardTitle; // 게시글 제목

    @Column(nullable = false)
    private LocalDateTime creationDate; // 게시글 작성 날짜

    @Column(nullable = false)
    private boolean anonymousStatus; // 익명 여부 (true: 익명, false: 실명)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String boardContent; // 게시글 내용 (길이가 긴 텍스트 저장)

    @Column(length = 255)
    private String attachedFilePath; // 첨부 파일 경로 (선택 사항)

    @Column(nullable = false)
    private int boardThumbs; // 좋아요 수

    @Column(nullable = false)
    private int viewCount; // 조회수

}
