package com.ftn.server.model.student;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
public class Dokument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private String contentType;

    private String direktorijum;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Student user;

    @Enumerated(EnumType.STRING)
    private FileType type;

    @Column(columnDefinition = "TEXT")
    private String localPath;

    @Column(columnDefinition = "TEXT")
    private String path;


    public enum FileType {

        IMAGE("image"), DOCUMENT("document"), TEXT("text");

        private final String text;

        FileType(String text) {
            this.text = text;
        }

        public static FileType fromString(String name) {
            return Arrays.stream(values()).filter(s -> s.name().equalsIgnoreCase(name)).findFirst().orElse(IMAGE);
        }

        public String getText() {
            return text;
        }

    }

}
