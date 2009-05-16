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
package com.discursive.jccook.script.velocity.extend;

public class StatUtil {
    public int average(int[] pArray) {
        int sum = 0;
        for (int i = 0; i < pArray.length; i++) {
            sum += pArray[i];
        }
        return (sum / pArray.length);
    }

    public int min(int[] pArray) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i] < min) {
                min = pArray[i];
            }
        }
        return (min);
    }

    public int max(int[] pArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i] > max) {
                max = pArray[i];
            }
        }
        return (max);
    }
}
