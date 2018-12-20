package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.domain.Book;
import net.skhu.model.Option;
import net.skhu.model.Pagination;

public interface BookRepository extends JpaRepository<Book, Integer>{
	Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "저자"),
			new Option(2, "제목"), new Option(3, "가격")  };
	Option[] orderBy = { new Option(0, "아이디순"), new Option(1, "아이디역순"),
			new Option(2, "제목순"), new Option(3, "저자순"), new Option(4, "가격순")};
	
	Sort[] sort = { new Sort(Sort.Direction.ASC, "id"),
			new Sort(Sort.Direction.DESC, "id"),
			new Sort(Sort.Direction.ASC, "title"),
			new Sort(Sort.Direction.ASC, "author"),
			new Sort(Sort.Direction.ASC, "price")};
	
	public default List<Book> findAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
        Page<Book> page;
        String searchText = pagination.getSt();
        switch (pagination.getSb()) {
        case 1: page = this.findByAuthorContains(searchText, pageable); break;
        case 2: page = this.findByTitleContains(searchText, pageable); break;
        case 3: page = this.findByPrice(Integer.parseInt(searchText), pageable); break;
        default: page = this.findAll(pageable); break;
        }
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
	
	public Page<Book> findById(int id, Pageable pageable);
	public Page<Book> findByAuthorContains(String author, Pageable pageable);
	public Page<Book> findByTitleContains(String title, Pageable pageable);
	public Page<Book> findByPrice(int price, Pageable pageable);
	
    List<Book> findBooksByIdOrTitle(String id, String title);
    
    @Modifying
    @Query("UPDATE Book SET "
    		+ "title=:title, author=:author, price=:price, categoryId=:categoryId,"
    		+ "publisherId=:publisherId, available=:available WHERE id=:id")
    public void update(@Param("id") int id, @Param("title") String title, @Param("author") String author, @Param("price") int price,
    		@Param("categoryId") int categoryId, @Param("publisherId") int publisherId, @Param("available") boolean available);
}
