class Book {
	private String author;
	private String title;
	private String owner;
	
	public Book(String author, String title, String owner) {
		this.author = author;
		this.title = title;
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return owner + "이 구입한 도서: " + author+"의 " + title; 
	}
	
	@Override
	public boolean equals(Object obj) {
		Book b = (Book)obj;
		if(author == b.author && title == b.title)
			return true;
		else
			return false;
	}
}

public class BookApp {
	public static void main(String[] args) {
		Book a = new Book("황기태", "명품자바", "김하진");
		Book b = new Book("황기태", "명품자바", "하여린");
		System.out.println(a);
		System.out.println(b);
		if(a.equals(b)) 
			System.out.println("같은 책");
		else
			System.out.println("다른 책");			
	}
}
