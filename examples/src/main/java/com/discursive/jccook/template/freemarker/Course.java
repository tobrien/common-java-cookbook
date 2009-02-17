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

public class Course {

    private String dept;
    private int num;
    private String name;
    private String professor;

    public String getDept() {
        return dept;
    }
    public String getName() {
        return name;
    }
    public int getNum() {
        return num;
    }
    public String getProfessor() {
        return professor;
    }

    public void setDept(String pDept) {
        dept = pDept;
    }
    public void setName(String pName) {
        name = pName;
    }
    public void setNum(int pNum) {
        num = pNum;
    }
    public void setProfessor(String pProfessor) {
        professor = pProfessor;
    }

}
