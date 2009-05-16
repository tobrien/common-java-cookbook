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

import java.util.Date;

public class Exam {
    private double score;
    private String name;
    private Date date;
    private double weight;

    public Date getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }
    public double getWeight() {
        return weight;
    }

    public void setDate(Date pDate) {
        this.date = pDate;
    }
    public void setName(String pName) {
        name = pName;
    }
    public void setScore(double pScore) {
        score = pScore;
    }
    public void setWeight(double pWeight) {
        weight = pWeight;
    }

}
