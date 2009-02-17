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
package com.discursive.jccook.xml.jxpath;

import java.util.HashMap;
import java.util.Map;

public class Atmosphere {
    private Double cloudTemp;
    private Double pressure;
    private Map components = new HashMap();

    public Double getCloudTemp() { return cloudTemp; }
    public Map getComponents() { return components; }
    public Double getPressure() { return pressure; }

    public void setCloudTemp(Double t) { cloudTemp = t; }
    public void setPressure(Double p) { pressure = p; }

    public void addComponent( String symbol, Double percentage ) {
        components.put( symbol, percentage );
    }
    public void addOther( Double percentage ) {
        components.put( "Other", percentage );
    }
}
