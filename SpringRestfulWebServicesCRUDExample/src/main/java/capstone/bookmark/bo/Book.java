package capstone.bookmark.bo;

public class Book{
	
	int id;
	String name;	
	String author;
	String category;
	String desc;
	long price;

	public Book() {
		super();
	}
	public Book(int i,String name,String author,String category,String desc,long price) {
		super();
		this.id = i;
		this.name = name;
		this.author = author;
		this.category = category;
		this.desc = desc;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public boolean categoryMatch(String cat) {
		if(this.category != null && this.category.equals(cat)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}