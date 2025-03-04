package com.ESC_club.esc.Entity;

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

    private Long board_id; // 게시글의 고유 ID (자동 증가)

    @ManyToOne // 다대일 관계 (게시글 여러 개가 하나의 회원에게 속함)
    @JoinColumn( nullable = false)
    private Member student; // 회원 테이블과 연결된 외래 키

    @Column( nullable = false, length = 50)
    private String board_category; // 게시글의 카테고리 (예: 공지사항, 자유게시판 등)

    @Column( nullable = false, length = 255)
    private String board_title; // 게시글 제목

    @Column(nullable = false)
    private LocalDateTime creation_date; // 게시글 작성 날짜

    @Column(nullable = false)
    private boolean anonymous_status; // 익명 여부 (true: 익명, false: 실명)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String board_content; // 게시글 내용 (길이가 긴 텍스트 저장)

    @Column(length = 255)
    private String attached_file_path; // 첨부 파일 경로 (선택 사항)

    @Column(nullable = false)
    private int board_thumbs; // 좋아요 수

    @Column(nullable = false)
    private int view_count; // 조회수

}
