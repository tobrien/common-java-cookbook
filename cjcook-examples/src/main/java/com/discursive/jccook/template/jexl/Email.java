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
package com.discursive.jccook.template.jexl;

import java.util.Date;

public class Email {

    private String subject;
    private String from;
    private String body;
    private Date received;
    private String test = "TEST";

    public String getBody() {
        return body;
    }
    public String getFrom() {
        return from;
    }
    public Date getReceived() {
        return received;
    }
    public String getSubject() {
        return subject;
    }
    public String getTest() {
        return test;
    }

    public void setBody(String pBody) {
        body = pBody;
    }
    public void setFrom(String pFrom) {
        from = pFrom;
    }
    public void setReceived(Date pReceived) {
        received = pReceived;
    }
    public void setSubject(String pSubject) {
        subject = pSubject;
    }

}
