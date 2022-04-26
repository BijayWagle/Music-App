package com.example.music.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.music.model.Music;
	import com.example.music.service.MusicService;

	@RestController
	@RequestMapping("/api")
	public class MusicController {
	        @Autowired
	        MusicService mscService;
	       
	        @RequestMapping(value="/playlist/track", method=RequestMethod.POST)
	        public Music createMusic(@RequestBody Music msc) {
	            return mscService.createMusic(msc);
	        }
	        @RequestMapping(value="/playlist/track", method=RequestMethod.GET)
	        public List<Music> readMusic() {
	            return mscService.getMusic();
	        }
	        @GetMapping("/playlist/track/{Id}")
	        public Optional<Music> getMusicById(@PathVariable (value="Id") Long Id ){
            return mscService.getMusicById(Id);
            }
	        @RequestMapping(value="/playlist/track/{Id}", method=RequestMethod.PUT)
	        public Music readMusic(@PathVariable(value = "Id") Long id, @RequestBody Music mscDetails) {
	            return mscService.updateMusic(id, mscDetails);
	        }

	        @RequestMapping(value="/playlist/track/{Id}", method=RequestMethod.DELETE)
	        public void deleteMusic(@PathVariable(value = "Id") Long id) {
	            mscService.deleteMusic(id);
	        }
	        
	        @RequestMapping(value="/playlist/track/{Id}/{newName}",method=RequestMethod.PATCH)
	        public Music fixMusic(@PathVariable(value="Id")Long id, @PathVariable (value="newName")String newName){
	        return mscService.fixMusic(id, newName);
	}
	
}
