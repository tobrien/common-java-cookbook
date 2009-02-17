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
package com.discursive.jccook.lang;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TaxReturn {

    private String ssn;
    private int year;
    private String lastName;
    private BigDecimal taxableIncome;

    public TaxReturn() {
    }
    public TaxReturn(
        String pSsn,
        int pYear,
        String pLastName,
        BigDecimal pTaxableIncome) {
        setSsn(pSsn);
        setYear(pYear);
        setLastName(pLastName);
        setTaxableIncome(pTaxableIncome);
    }

    public String getSsn() {
        return ssn;
    }
    public void setSsn(String pSsn) {
        ssn = pSsn;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int pYear) {
        year = pYear;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public BigDecimal getTaxableIncome() {
        return taxableIncome;
    }
    public void setTaxableIncome(BigDecimal pTaxableIncome) {
        taxableIncome = pTaxableIncome;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ssn", ssn)
            .append("year", year)
            .append("lastName", lastName)
            .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder(3, 7).append(ssn).append(year).toHashCode();
    }

    public boolean equals(Object pObject) {
        boolean equals = false;
        if (pObject instanceof TaxReturn) {
            TaxReturn bean = (TaxReturn) pObject;
            equals =
                (new EqualsBuilder()
                    .append(ssn, bean.ssn)
                    .append(year, bean.year))
                    .isEquals();
        }
        return equals;
    }

    public int compareTo(Object pObject) {
        return CompareToBuilder.reflectionCompare(this, pObject);
    }

}
