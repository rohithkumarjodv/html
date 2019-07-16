package com.mphasis.player.bo;

import java.util.List;

import com.mphasis.player.beans.Player;
import com.mphasis.player.dao.PlayerDao;
import com.mphasis.player.dao.PlayerDaoImp;

public class PlayerBoImp implements PlayerBo {

	
	PlayerDao playerdao;
	public PlayerBoImp() {
		playerdao=new PlayerDaoImp();
	}

	@Override
	public List<Player> getAllPlayers() {
		
		 return playerdao.getAllPlayers();
	}

}
