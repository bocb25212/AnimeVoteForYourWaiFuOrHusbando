package com.Sean.pojo;

import java.util.Comparator;

import com.Sean.pojo.Animecharacter;

public class AnimeCharacterComparator implements Comparator<Animecharacter> {

	@Override
	public int compare(Animecharacter a1, Animecharacter a2) {
		if(a1.getVotecount()>a2.getVotecount()) {
			return -1;
		}else {
			return 1;
		}
	}

}
