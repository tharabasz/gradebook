package org.gradebook.school.student.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static org.gradebook.school.student.dao.model.StudentEntity.TABLE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = TABLE)
public class StudentEntity {

    public static final String TABLE = "student";

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String studentUUID;

    private String firstName;
    private String lastName;
    private String middleName;

    private LocalDate dateOfBirth;
    private String gender;

    private String email;
    private String phone;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "student_guardians", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "guardian_name")
    private List<String> guardianNames;

    @ElementCollection
    @CollectionTable(name = "student_guardian_contacts", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "contact")
    private List<String> guardianContacts;

    private LocalDate enrollmentDate;

    private Double averageGrade;

    private Boolean active;

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
