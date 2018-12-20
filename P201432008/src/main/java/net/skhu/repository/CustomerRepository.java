package net.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Customer;
import net.skhu.model.Option;
import net.skhu.model.Pagination;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "이름"),
			new Option(2, "직위"), new Option(3, "도시")  };
	
	Option[] orderBy = { new Option(0, "id"), new Option(1, "직위"),
			new Option(2, "도시")};
	
	Sort[] sort = { new Sort(Sort.Direction.ASC, "id"),
			new Sort(Sort.Direction.ASC, "jobTitle"),
			new Sort(Sort.Direction.ASC, "city")};
	
	public default List<Customer> findAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);
        Page<Customer> page;
        String searchText = pagination.getSt();
        switch (pagination.getSb()) {
        case 1: page = this.findByLastNameContainingOrFirstNameContaining(searchText, searchText, pageable); break;
        case 2: page = this.findByJobTitleContains(searchText, pageable); break;
        case 3: page = this.findByCityStartsWith(searchText, pageable); break;
        default: page = this.findAll(pageable); break;
        }
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
	
	public Page<Customer> findByLastNameContainingOrFirstNameContaining(String lastName, String firstName, Pageable pageable);
	public Page<Customer> findByJobTitleContains(String jobTitle, Pageable pageable);
	public Page<Customer> findByCityStartsWith(String city, Pageable pageable);
}
