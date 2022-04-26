package com.example.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.model.Music;
import com.example.music.repository.MusicRepository;


@Service
public class MusicService{

        @Autowired//dependency injection
            MusicRepository mscRepository;        


//CREATE 
public Music createMusic(Music msc) {
 return mscRepository.save(msc);
}

//READ
public List<Music> getMusic() {
 return mscRepository.findAll();
}
public Optional<Music> getMusicById(Long Id){
	return mscRepository.findById(Id);
}

//DELETE
public void deleteMusic(Long Id) {
 mscRepository.deleteById(Id);
}
//UPDATE
public Music updateMusic(Long Id, Music musicDetails) {
     Music msc = mscRepository.findById(Id).get();
     msc.setName(musicDetails.getName());
     msc.setGenre(musicDetails.getGenre());
     msc.setArtist(musicDetails.getArtist());
     msc.setDuration(musicDetails.getDuration());
     
     return mscRepository.save(msc);                                
}
//uptodate(patch)
public Music fixMusic(Long id, String newName) {
	Music msc= mscRepository.findById(id).get();
	msc.setName(newName);
    //msc.setGenre(musicDetails.getGenre());
    //msc.setArtist(musicDetails.getArtist());
    //msc.setDuration(musicDetails.getDuration());
     return mscRepository.save(msc);                                
}
}



