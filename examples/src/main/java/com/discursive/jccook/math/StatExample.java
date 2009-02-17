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
package com.discursive.jccook.math;

import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.apache.commons.math.stat.descriptive.moment.Skewness;
import org.apache.commons.math.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math.stat.descriptive.moment.Variance;
import org.apache.commons.math.stat.descriptive.rank.Max;
import org.apache.commons.math.stat.descriptive.rank.Min;
import org.apache.commons.math.stat.descriptive.rank.Percentile;
import org.apache.commons.math.stat.descriptive.summary.Product;
import org.apache.commons.math.stat.descriptive.summary.Sum;


public class StatExample {

	public static void main(String[] args) {
		double[] values = new double[] { 2.3, 5.4, 6.2, 7.3, 23.3 };

		System.out.println( "min: " + StatUtils.min( values ) );
		System.out.println( "max: " + StatUtils.max( values ) );
		System.out.println( "mean: " + StatUtils.mean( values ) );
		System.out.println( "product: " + StatUtils.product( values ) );
		System.out.println( "sum: " + StatUtils.sum( values ) );
		System.out.println( "variance: " + StatUtils.variance( values ) );

		// Measures from previous example
		Min min = new Min();
		System.out.println( "min: " + min.evaluate( values ) );
		Max max = new Max();
		System.out.println( "max: " + max.evaluate( values ) );
		Mean mean = new Mean();
		System.out.println( "mean: " + mean.evaluate( values ) );
		Product product = new Product();
		System.out.println( "product: " + product.evaluate( values ) );
		Sum sum = new Sum();
		System.out.println( "sum: " + sum.evaluate( values ) );
		Variance variance = new Variance();
		System.out.println( "variance: " + variance.evaluate( values ) );
		
		// New measures
		Percentile percentile = new Percentile();
		System.out.println( "80 percentile value: " + percentile.evaluate( values, 80.0 ) );
		GeometricMean geoMean = new GeometricMean();
		System.out.println( "geometric mean: " + geoMean.evaluate( values ) );
		StandardDeviation stdDev = new StandardDeviation();
		System.out.println( "standard dev: " + stdDev.evaluate( values ) );
		Skewness skewness = new Skewness();
		System.out.println( "skewness: " + skewness.evaluate( values ) );
		Kurtosis kurtosis = new Kurtosis();
		System.out.println( "kurtosis: " + kurtosis.evaluate( values ) );
		
	}
}
