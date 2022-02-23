package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private long idUser;
	private int phoneNbr;
	private String email;
	private String password;
	private String name;
	private String description;
	private String image;
	private String sanitary_pass;
	private String profession;
	private String domain;
	private String followersNbr;
	private String adress;
	@Temporal(TemporalType.DATE)
	private Date dateNaiss;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Post> posts ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Claim> claims ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Message> messages ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Opportunity> opportunity;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<Travel> travels;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<Invitation> invitations;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<Recompence>recompence ;
	
	
	@OneToOne(mappedBy="user")
	private Metrique metrique;

}
