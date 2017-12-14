package cci.ch13;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement:
 * 
 * There is a class country that has method 
 * getContinent() and getPopulation(). Write a function 
 * "int getPopulation(List<Country> countries, String continent)"
 * that computes the total population of a given continent, 
 * given a list of all countries and the name of a continent.
 * 
 * </br>
 *
 */

public class LabdaExpressions {
	
	/**
	 * Method to get population using advanced java loop
	 * @param countries 
	 * @param continent
	 * @return {@link int}
	 */
	
	public static int getPopulationBF(List<Country> countries, String continent) {
		int totalPopulation = 0;
		for(Country country : countries) {
			if (country.getContinent().equalsIgnoreCase(continent)) {
				totalPopulation += country.getPopulation();
			}
		}
		return totalPopulation;
	}
	
	/**
	 * Class Country
	 * 
	 * @author basila
	 *
	 */
	
	public static class Country {
		private String continent;
		private int population;
		
		/**
		 * Constructor
		 * 
		 * @param continent
		 * @param population
		 */
		public Country(String continent, int population) {
			this.continent = continent;
			this.population = population;
		}
		
		public String getContinent() {
			return continent;
		}
		
		public void setContinent(String continent) {
			this.continent = continent;
		}
		
		public int getPopulation() {
			return population;
		}
		
		public void setPopulation(int population) {
			this.population = population;
		}
	}
	
	public static void main(String[] args) {
		Country SouthAfrica = new Country("Africa", 30000);
		Country Nigeria = new Country("Africa", 40000);

		System.out.println(SouthAfrica.getContinent());
		
		ArrayList<Country> countries = new ArrayList<Country>();

		countries.add(SouthAfrica);
		countries.add(Nigeria);
		System.out.println(getPopulationBF(countries, "Africa"));
	}

}
