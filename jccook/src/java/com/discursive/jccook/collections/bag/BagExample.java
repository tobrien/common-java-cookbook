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
package com.discursive.jccook.collections.bag;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.lang.StringUtils;

public class BagExample {

	Bag inventoryBag = new HashBag();
	
	Album album1 = new Album( "Radiohead", "OK Computer" );
	Album album2 = new Album( "Kraftwerk", "The Man-Machine" );
	Album album3 = new Album( "Charlie Parker", "Now's the Time" );
	Album album4 = new Album( "ABBA", "ABBA - Gold: Greatest Hits" );

	public static void main(String[] args) {
		BagExample example = new BagExample();
		example.start();
	}
	
	private void start() {
		// Read our inventory into a Bag
		populateInventory();

		System.out.println( "Inventory before Transactions" );
		printAlbums( inventoryBag );
		printSeparator();

		// A Customer wants to purchase 400 copies of ABBA and 2 copies of Radiohead
		Bag shoppingCart1 = new HashBag();
		shoppingCart1.add( album4, 500 );
		shoppingCart1.add( album3, 150 );
		shoppingCart1.add( album1, 2 );
		checkout( shoppingCart1, "Customer 1" );
		
		// Another Customer wants to purchase 600 copies of ABBA 
		Bag shoppingCart2 = new HashBag();
		shoppingCart2.add( album4, 600 );
		checkout( shoppingCart2, "Customer 2" );		

		// Another Customer wants to purchase 3 copies of Kraftwerk
		Bag shoppingCart3 = new HashBag();
		shoppingCart3.add( album2, 3 );
		checkout( shoppingCart3, "Customer 3" );		

		System.out.println( "Inventory after Transactions" );
		printAlbums( inventoryBag );
		
	}
	
	private void populateInventory() {
		inventoryBag.add( album1, 200 );
		inventoryBag.add( album2, 100 );
		inventoryBag.add( album3, 500 );
		inventoryBag.add( album4, 900 );
	}
	
	private void printAlbums( Bag albumBag ) {
		Set albums = albumBag.uniqueSet();
		Iterator albumIterator = albums.iterator();
		while( albumIterator.hasNext() ) {
			Album album = (Album) albumIterator.next();
			NumberFormat format = NumberFormat.getInstance();
			format.setMinimumIntegerDigits( 3 );
			format.setMaximumFractionDigits( 0 );
			System.out.println( "\t" +  
				format.format( albumBag.getCount( album ) ) + " - " + album.getBand()  );
		}
	}
	
	private void checkout( Bag shoppingCart, String customer ) {
		// Check to see if we have the inventory to cover this purchase
		if( inventoryBag.containsAll( (Collection) shoppingCart ) ) {
			// Remove these items from our inventory
			inventoryBag.removeAll( (Collection) shoppingCart );
			System.out.println( customer + " purchased the following items:" );
			printAlbums( shoppingCart );
		} else {
			System.out.println( customer + ", I'm sorry but we are unable to fill your order." );
		}
		printSeparator();
	}
	
	private void printSeparator() {
		System.out.println( StringUtils.repeat( "*", 65 ) );
	}

}
