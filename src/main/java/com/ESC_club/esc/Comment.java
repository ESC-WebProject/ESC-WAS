package com.ESC_club.esc;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity // JPA 엔티티 선언
@Table(name = "comment") // 실제 DB 테이블명
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id; // 댓글의 고유 ID (자동 증가)

    @ManyToOne(fetch = FetchType.LAZY) // 회원(Member) 엔티티와 다대일 관계 설정
    @JoinColumn(nullable = false)
    private Member student; // 댓글 작성자 (회원)

    @ManyToOne(fetch = FetchType.LAZY) // 게시판(Board) 엔티티와 다대일 관계 설정
    @JoinColumn( nullable = false)
    private Board board; // 댓글이 속한 게시글

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment_content; // 댓글 내용

    @Column( nullable = false)
    private int comment_thumbs; // 댓글 좋아요 수

    @Column(nullable = false)
    private boolean comment_anonymous_state; // 익명 여부 (true: 익명, false: 실명)

    @Column(nullable = false)
    private LocalDateTime creation_date; // 댓글 작성 날짜
}
