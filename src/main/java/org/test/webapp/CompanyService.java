package org.test.webapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompanyService {
	
	private static CompanyService instance;
	private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());

	private final HashMap<Long, Company> companies = new HashMap<>();
	private long nextId = 0;

	CompanyService() {
	}

	/**
	 * @return a reference to an example facade for Company objects.
	 */
	public static CompanyService getInstance() {
		if (instance == null) {
			instance = new CompanyService();
			instance.ensureTestData();
		}
		return instance;
	}

	/**
	 * @return all available Company objects.
	 */
	public synchronized List<Company> findAll() {
		return findAll(null);
	}

	/**
	 * Finds all Company's that match given filter.
	 *
	 * @param stringFilter
	 *            filter that returned objects should match or null/empty string
	 *            if all objects should be returned.
	 * @return list a Company objects
	 */
	public synchronized List<Company> findAll(String stringFilter) {
		ArrayList<Company> arrayList = new ArrayList<>();
		for (Company contact : companies.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
						|| contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(contact.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, new Comparator<Company>() {

			@Override
			public int compare(Company o1, Company o2) {
				return (int) (o2.getId() - o1.getId());
			}
		});
		return arrayList;
	}

	/**
	 * Finds all Company's that match given filter and limits the resultset.
	 *
	 * @param stringFilter
	 *            filter that returned objects should match or null/empty string
	 *            if all objects should be returned.
	 * @param start
	 *            the index of first result
	 * @param maxresults
	 *            maximum result count
	 * @return list a Company objects
	 */
	public synchronized List<Company> findAll(String stringFilter, int start, int maxresults) {
		ArrayList<Company> arrayList = new ArrayList<>();
		for (Company contact : companies.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
						|| contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(contact.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, new Comparator<Company>() {

			@Override
			public int compare(Company o1, Company o2) {
				return (int) (o2.getId() - o1.getId());
			}
		});
		int end = start + maxresults;
		if (end > arrayList.size()) {
			end = arrayList.size();
		}
		return arrayList.subList(start, end);
	}

	/**
	 * @return the amount of all customers in the system
	 */
	public synchronized long count() {
		return companies.size();
	}

	/**
	 * Deletes a customer from a system
	 *
	 * @param value
	 *            the Company to be deleted
	 */
	public synchronized void delete(Company value) {
		companies.remove(value.getId());
	}

	/**
	 * Persists or updates customer in the system. Also assigns an identifier
	 * for new Company instances.
	 *
	 * @param entry
	 */
	public synchronized void save(Company entry) {
		if (entry == null) {
			LOGGER.log(Level.SEVERE,
					"Company is null. Are you sure you have connected your form to the application as described in tutorial chapter 7?");
			return;
		}
		if (entry.getId() == null) {
			entry.setId(nextId++);
		}
		try {
			entry = (Company) entry.clone();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		companies.put(entry.getId(), entry);
	}

	/**
	 * Sample data generation
	 */
	public void ensureTestData() {
		if (findAll().isEmpty()) {
			final String[] names = new String[] { "Coke", "fanta", "redbull",
					"Monster", "Macdonald", "Shiftup", "Gustavsson", "Svensson",
					"Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
					"Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
					"Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
					"Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
					"Jaydan Jackson", "Bernard Nilsen" };
			Random r = new Random(0);
			for (String name : names) {
				String[] split = name.split(" ");
				Company c = new Company();
				c.setName(name);
				save(c);
			}
		}
	}

	public Map<String, Integer> getStats() {
		
		HashMap<String, Integer> stats = new HashMap<>();
		stats.put("Coke", 1);
		stats.put("Coke", 2);
		stats.put("Coke", 3);
		stats.put("Coke", 4);
		stats.put("RedBull", 1);
		stats.put("RedBull", 2);
		stats.put("Monster", 1);
		stats.put("Monster", 2);
		stats.put("Monster", 3);
		stats.put("Monster", 4);
		stats.put("São Geraldo", 1);
		stats.put("São Geraldo", 2);
		stats.put("São Geraldo", 3);
		stats.put("São Geraldo", 4);
		stats.put("São Geraldo", 5);
		
		
		return stats;
	}

}
