package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Member member;

    private String boardCategory;
    private String boardTitle;
    private LocalDateTime creationDate;
    private boolean anonymousStatus;
    private String boardContent;
    private String attachedFilePath;
    private int boardThumbs;
    private int viewCount;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;
}