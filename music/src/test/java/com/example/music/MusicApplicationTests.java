package com.example.music;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.music.model.Music;
import com.example.music.repository.MusicRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MusicApplicationTests {

	@Autowired
	MusicRepository mRepo;
	
	@Test
	@Order(1)
	public void testCreate() {
	Music m	=new Music();
	//m.setId(1L);
	m.setName("Roar");
	m.setGenre("Rock");
	m.setArtist("AC DC");
	m.setDuration(200);
	mRepo.save(m);
	//to write the test case
	assertNotNull(mRepo.findById(6L).get());
}
	@Test
	@Order(2)
	public void testReadAll() {
		List<Music>list=mRepo.findAll();
		assertTrue(list.size()>0);
		//assertThat(list).size().isGreaterThan(0);
		
	}
	@Test
	@Order(3)
	public void testSingleMusic() {
	Music music= mRepo.findById(3L).get();
	assertEquals("TNT",music.getName());
	}
	@Test
	@Order(4)
	public void testUpdate() {
		Music m=mRepo.findById(4L).get();
		m.setName("We will rock you");
		mRepo.save(m);
		assertNotEquals("TNT",mRepo.findById(4L).get().getName());
	}
	@Test
	@Order(5)
	public void testDelete() {
		mRepo.deleteById(5L);
		//assertFalse(mRepo.existsById(4L)).isFalse();
		assertThat(mRepo.existsById(5L)).isFalse();
	}
		
}