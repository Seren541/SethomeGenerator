package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Generator {
	
	public static void main(String[] args) {
		
		
		String[] homes = {"base", "cb", "close", "gaurd",  "iron", "lake", "new", "pick", "raid", "spa", "tre", "indu", "jug", 
				"doom", "tb", "hero", "vault",  "isle", "high", "drop", "trap", "trick", "pill", "vill", "phant", 
				"trade", "mine", "team", "farm", "golem", "main", "ice", "jungle", "jung", "i", "t", "meetup", "cast", 
				"castle", "ship", "mountain", "pillager", "villager", "hall", "horse", "port", "portal", "bart", "seren",
				"alex", "teleport", "trade", "gaurdian", "santa", "obi", "house", "crop", "crops", "carrot", "potato", "pass", "passive", "mob", "flush",
				"wool", "wood", "shovel", "pickaxe", "axe", "hoe", "hay", "sponge", "spawner", "spawn", "cave", "spider", "creeper", "zombie", "skele",
				"skeleton", "husk", "stray", "sand", "brick", "arrow", "range", "trap", "cob", "art", "gall", "obby", "obsidian"};
		String[] nhomes = {"gold", "g", "lav", "pigtrade", "pigl", "piglin", "netherite", "neth", "fortress", "basalt", "hub", "bed", "hog",
				"hidden", "op", "anchor", "red", "ghast", "strider", "hoglin", "wither", "skull", "fort", "blaze", "flat", "loot", "wind", "window"};
		String[] ehomes = {"end", "ender", "endermen", "e", "city", "xp", "fly", "void", "endgate", "stash", "mue", "under",
				"ely", "shulk", "chorus", "purpur", "mast", "store", "storage", "fruit", "map"};
		String[] repHome = {"base", "iron", "new", "raid", "indu", "trade", "farm", "trade", "gaurdian", "wool", "vill", "hall", "mob", "spawner",
				"castle", "obi", "jungle", "ice", "sand"};
		String[] nethRepHome = {"gold", "piglin", "netherite", "fortress", "hoglin", "skull", "loot", "op", "hidden", "ghast"};
		String[] endRepHome = {"endermen", "endgate", "chorus", "mue", "xp", "fly", "shulk"};
		
		int gmin = 1;
	    int gmax = 7;
	    
		int min = -500000;
	    int max = 500000;
	    
		int nmin = -62500;
	    int nmax = 62500;
	    
	    int hmin = 15;
		int hmax = 140;
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> nlist = new ArrayList<>();
		ArrayList<Integer> elist = new ArrayList<>();
		ArrayList<String> listofhomes = new ArrayList<String>();
		
		ArrayList<String> repHomeSearch = new ArrayList<>(Arrays.asList(repHome));
		ArrayList<String> nethRepHomeSearch = new ArrayList<>(Arrays.asList(nethRepHome));
		ArrayList<String> endRepHomeSearch = new ArrayList<>(Arrays.asList(endRepHome));
		
		
		System.out.println("How many Sethomes would you like to generate? (Must be 20 or less)");
		Scanner num = new Scanner(System.in);  //Number of sethomes input

	    String amount = num.nextLine(); 
	    DecimalFormat numberFormat = new DecimalFormat("0.##");
	    double rand1 = 0;
    	int rand2 = 0;
    	double rand3 = 0;
    	int hom = 0;
	    
	    int amo = Integer.parseInt(amount);
	    int repeatHome = 0;
	    
	    if (0 < amo && amo < 21) { //limits amount to be generated so that the computer can't get stuck searching for names it doesn't have.
	    	
	    for (int i = 0; i < amo; i++) {
	    	
	        int d = (int)(Math.random() * (gmax - gmin + 1) + gmin);
	    	
        	if (repeatHome > 0) {
        		
        		int chance = (int)(Math.random() * (5 - 1 + 1) + 1); //in this case there is a 2 in 5 chance
        		
        		if (chance == 1 || chance == 2) {
        			
        			if (repeatHome == 1) {
        				
        	        	rand1 = Math.random() * (max - min + 1) + min;
        	        	rand2 = (int)(Math.random() * (hmax - hmin + 1) + hmin);
        	        	rand3 = Math.random() * (max - min + 1) + min; 
        				listofhomes.add(homes[hom] + "2 at x: " + numberFormat.format(rand1) + ", y: " + rand2 + ", z:" + numberFormat.format(rand3) + ", world");
        			}
        			
        			if (repeatHome == 2) {
        	        	rand1 = Math.random() * (nmax - nmin + 1) + nmin;
        	        	rand2 = (int)(Math.random() * (hmax - hmin + 1) + hmin);
        	        	rand3 = Math.random() * (nmax - nmin + 1) + nmin; 
        	        	listofhomes.add(nhomes[hom] + "2 at x: " + numberFormat.format(rand1) + ", y: " + rand2 + ", z:" + numberFormat.format(rand3) + ", world_the_nether");

        			}       
        			
        			if (repeatHome == 3) {
        	        	rand1 = Math.random() * (max - min + 1) + min;
        	        	rand2 = (int)(Math.random() * (hmax - hmin + 1) + hmin);
        	        	rand3 = Math.random() * (max - min + 1) + min; 
        	        	listofhomes.add(ehomes[hom] + "2 at x: " + numberFormat.format(rand1) + ", y: " + rand2 + ", z:" + numberFormat.format(rand3) + ", world_the_end");
        			}
        			
        		}
        		
        		else {
        			i--;
        		}
        		
        		repeatHome = 0;        		
        		
        	}
	        
        	else if (d == 1 || d == 2 || d == 3 || d == 4) {
	        
	    	    boolean homused = true;
	    	    
	        	rand1 = Math.random() * (max - min + 1) + min;
	        	rand2 = (int)(Math.random() * (hmax - hmin + 1) + hmin);
	        	rand3 = Math.random() * (max - min + 1) + min; 
	        	hom = 0;
	        	
	        	while (homused) {
	        	hom = (int)(Math.random() * ((homes.length-1) - 0 + 1) + 0);
	        	if (list.contains(hom)) {
	        		
	        		
	        	}
	        	else {
	        	homused = false;
	        	}
	        	
	        	}
	        	
	        	
	        	list.add(hom);
	        	nlist.add(-1);
	        	elist.add(-1);

	        	
	        	if (repHomeSearch.contains(homes[hom])) {
	        		repeatHome = 1;
	        	}
	        	

	        	listofhomes.add(homes[hom] + " at x: " + numberFormat.format(rand1) + ", y: " + rand2 + ", z:" + numberFormat.format(rand3) + ", world");
	        }
	        
        	else if (d == 5 || d == 6) {
	    	   
	        	boolean homused = true;
	    	    
	        	rand1 = Math.random() * (nmax - nmin + 1) + nmin;
	        	rand2 = (int)(Math.random() * (hmax - hmin + 1) + hmin);
	        	rand3 = Math.random() * (nmax - nmin + 1) + nmin; 
	        	hom = 0;
	        	
	        	while (homused) {
	        	hom = (int)(Math.random() * ((nhomes.length-1) - 0 + 1) + 0);
	        	if (nlist.contains(hom)) {
	        		
	        		
	        	}
	        	else {
	        	homused = false;
	        	}
	        	
	        	}
	        	
	        	list.add(-1);
	        	nlist.add(hom);
	        	elist.add(-1);
	        	
	        	if (nethRepHomeSearch.contains(nhomes[hom])) {
	        		repeatHome = 2;
	        	}
	        	

	        	listofhomes.add(nhomes[hom] + " at x: " + numberFormat.format(rand1) + ", y: " + rand2 + ", z:" + numberFormat.format(rand3) + ", world_the_nether");
	        }
	        
        	else if (d == 7) {
		        
	    	    boolean homused = true;
	    	    
	        	rand1 = Math.random() * (max - min + 1) + min;
	        	rand2 = (int)(Math.random() * (hmax - hmin + 1) + hmin);
	        	rand3 = Math.random() * (max - min + 1) + min; 
	        	hom = 0;
	        	
	        	while (homused) {
	        	hom = (int)(Math.random() * ((ehomes.length-1) - 0 + 1) + 0);
	        	if (elist.contains(hom)) {
	        		
	        		
	        	}
	        	else {
	        	homused = false;
	        	}
	        	
	        	}
	        	
	        	list.add(-1);
	        	nlist.add(-1);
	        	elist.add(hom);
	        	
	        	if (endRepHomeSearch.contains(ehomes[hom])) {
	        		repeatHome = 3;
	        	}
	        	

	        	listofhomes.add(ehomes[hom] + " at x: " + numberFormat.format(rand1) + ", y: " + rand2 + ", z:" + numberFormat.format(rand3) + ", world_the_end");
	        }
	    }

	    Collections.sort(listofhomes);
	    
		   for(String counter: listofhomes){
				System.out.println(counter);
			}
		   
		System.out.println();
		System.out.print("Press enter to exit.");
		
		
		Scanner ex = new Scanner(System.in);

	    String exitKey = num.nextLine(); 
	    }
	}

}
