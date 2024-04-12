package com.spring.di06;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInfo {
private Player player;

void getPlayerInfo() {
	if(player != null) {
		System.out.println("선수 이름: "+player.getName());
		System.out.println("선수 나이: "+player.getAge());
		System.out.println("선수 역할: "+player.getPosition());
		System.out.println("선수 체중: "+player.getWeight());
		System.out.println("선수 키: "+player.getHeight());
	}
	}
}
