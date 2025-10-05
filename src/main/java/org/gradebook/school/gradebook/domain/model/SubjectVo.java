package org.gradebook.school.gradebook.domain.model;

public record SubjectVo (String name,
                         boolean isRequired,
                         boolean calculateToFinalGrade) {

}
