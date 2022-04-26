package com.example.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	@Entity
	@Table(name = "Playlist")
	
	public class Music {  
	        @Id
	        @GeneratedValue(strategy = GenerationType.IDENTITY)
	        @Column(name="id")
	            private Long id;
	        
	        @Column(name="name")
	        private String name;
	        
	       	@Column(name="genre")
	        private String genre;
	        
	        @Column(name="artist")
	        private String artist;

	        @Column(name="duration")
	        private int duration;

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getGenre() {
				return genre;
			}

			public void setGenre(String genre) {
				this.genre = genre;
			}

			public String getArtist() {
				return artist;
			}

			public void setArtist(String artist) {
				this.artist = artist;
			}

			public int getDuration() {
				return duration;
			}

			public void setDuration(int duration) {
				this.duration = duration;
			}
			
			 public Music() {
					super();
				}
			
			public Music(Long id, String name, String genre, String artist, int duration) {
				super();
				this.id = id;
				this.name = name;
				this.genre = genre;
				this.artist = artist;
				this.duration = duration;
			}

			@Override
			public String toString() {
				return "Music [id=" + id + ", name=" + name + ", genre=" + genre + ", artist=" + artist + ", duration="
						+ duration + "]";
			}

	        
	}
