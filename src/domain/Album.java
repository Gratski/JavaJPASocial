package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class represents an Album
 * 
 * @author JoaoR
 *
 */
@Entity
public class Album {

	@Id @GeneratedValue
	private int id;
	
	@Column(name="desigantion")
	private String designation;
	
	@ManyToOne
	private User owner;
	
	@OneToMany(mappedBy="album")
	private List<Picture> pictures;
}
