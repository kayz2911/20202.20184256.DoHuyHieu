package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private String content;
	
	public Book (String title, String category, float cost, String content) {
		super(title,category,cost);
		this.content = content;
	}
	
	public Book(String title, String category, float cost, List<String> authors, String content) {
		super(title,category,cost);
		this.authors = authors;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addAuthor(String authorName){
		int flag = 0;
		for(String author : authors) {
			if(author.compareTo(authorName) == 0) {
				System.out.println("The author has been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName){
		int flag = 0;
		for(String author : authors) {
			if(author.compareTo(authorName) != 0) {
				System.out.println("The author has not been exist");
				flag = 1;
			}
		}
		if(flag == 0) {
			authors.remove(authorName);
		}
	}
	
	public void play() {
		System.out.println("Can not play a book");
	}
	
	public String processContent() {
    	String result = "";
    	String[] contentSplit = content.split(" ");
    	List<String> contentTokens = new ArrayList<String>() ;
    			
    	for (int i = 0; i < contentSplit.length; i++) {
    		char last = contentSplit[i].charAt(contentSplit[i].length() - 1);
    		if (!((last >= '0' && last <= '9') || (last >= 'a' && last <= 'z') || (last >='A' && last <= 'Z'))) {
    			contentSplit[i] = contentSplit[i].substring(0, contentSplit[i].length()-1);
    		}
    		contentTokens.add(contentSplit[i]);
    	}
    	
    	Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
    	for (String item : contentTokens) {
    		if (wordFrequency.containsKey(item)) {
    			wordFrequency.replace(item, wordFrequency.get(item) + 1);
    		}else {
    			wordFrequency.put(item, 1);
    		}
    	}
    	
    	TreeMap<String, Integer> treeMap = new TreeMap<>();
    	treeMap.putAll(wordFrequency);
    	Set<Map.Entry<String, Integer>> setHashMap = treeMap.entrySet();
    	for (Map.Entry<String,Integer> i: setHashMap){
    		result = result + i.getKey() + ": " + i.getValue() + "  \n";    	
    	}
    	return result; 
    }
    
    @Override
    public String toString() {
		return id + ".Book "  + " " + title + " - " + category + " - " + cost +" $ " + "\nInformation: \n"  + processContent() +"\n";
	}

}
