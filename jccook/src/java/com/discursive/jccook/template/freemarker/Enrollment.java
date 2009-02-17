/* 
 * ========================================================================
 * 
 * Copyright 2005 Tim O'Brien.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
package com.discursive.jccook.template.freemarker;

import java.util.List;

public class Enrollment {
    private Student student;
    private Course course;
    private List exams;
    private int section;

    public Course getCourse() {
        return course;
    }
    public List getExams() {
        return exams;
    }
    public Student getStudent() {
        return student;
    }
    public int getSection() {
        return section;
    }

    public void setCourse(Course pCourse) {
        this.course = pCourse;
    }
    public void setExams(List pList) {
        exams = pList;
    }
    public void setStudent(Student pStudent) {
        this.student = pStudent;
    }
    public void setSection(int pSection) {
        section = pSection;
    }
}
