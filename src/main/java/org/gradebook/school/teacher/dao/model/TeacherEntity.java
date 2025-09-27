package org.gradebook.school.teacher.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static org.gradebook.school.teacher.dao.model.TeacherEntity.TABLE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = TABLE)
public class TeacherEntity {

    public static final String TABLE = "teacher";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String employeeId;

    private String firstName;
    private String lastName;
    private String middleName;

    private LocalDate dateOfBirth;
    private String gender;

    private String email;
    private String phone;

    @Embedded
    private Address address;

    private LocalDate hireDate;
    private String position;

    @ElementCollection
    @CollectionTable(name = "teacher_subjects", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "subject")
    private List<String> subjects;

    @ElementCollection
    @CollectionTable(name = "teacher_qualifications", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "qualification")
    private List<String> qualifications;

    private Boolean active;

    private Double salary;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String street;
        private String city;
        private String state;
        private String postalCode;
        private String country;
    }
}
