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

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private String name;
    private Double mass;
    private Double radius;
    private Orbit orbit;
    private Atmosphere atmosphere;
    private List moons = new ArrayList();

    public Atmosphere getAtmosphere() { return atmosphere; }
    public Double getMass() { return mass; }
    public List getMoons() { return moons; }
    public String getName() { return name; }
    public Orbit getOrbit() { return orbit; }
    public Double getRadius() { return radius; }

    public void setAtmosphere(Atmosphere a) { atmosphere = a; }
    public void setMass(Double m) { mass = m; }
    public void setMoons(List list) { moons = list; }
    public void setName(String n) { name = n; }
    public void setOrbit(Orbit o) { orbit = o; }
    public void setRadius(Double r) { radius = r; }

    public void addMoon( String name ) { moons.add( name ); }
}
