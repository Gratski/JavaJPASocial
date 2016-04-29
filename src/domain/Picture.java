package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This class represents an album's picture
 * 
 * @author JoaoR
 *
 */
@Entity
public class Picture {

	@Id @GeneratedValue
	private int id;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne @JoinColumn
	private Album album;
	
	@Column(name="path")
	private String path;
	
}
