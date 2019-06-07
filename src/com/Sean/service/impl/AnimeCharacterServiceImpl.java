package com.Sean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sean.mapper.AnimecharacterMapper;
import com.Sean.pojo.Animecharacter;
import com.Sean.service.AnimeCharacterService;
@Service
public class AnimeCharacterServiceImpl implements AnimeCharacterService{
	 @Autowired
	    public AnimecharacterMapper AnimecharacterMapper;
	@Override
	public void addAnimeCharacter(Animecharacter animeCharacter) {
		AnimecharacterMapper.insertSelective(animeCharacter);
	}

}
