package com.spring.di06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class Main {

	public static void main(String[] args) {
		
		// 스프링 컨테이너를 생성해야 됨.
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext
				("classpath:baseball.xml", "classpath:baseballteam.xml");
		
		// 스프링 컨테이너를 써서 빈을 가져와야 됨.
		//MessageImpl msg = ctx.getBean("msg", MessageImpl.class);
		PlayerInfo player = ctx.getBean("info", PlayerInfo.class);
		player.getPlayerInfo();
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		
		BaseBallTeam team = (BaseBallTeam)ctx.getBean("team");
		System.out.println("최강야구");
		System.out.println("대표팀 감독: "+team.getManager());
		System.out.println("대표팀 타격코치: "+team.getBattingCoach());
		System.out.println("대표팀 투수코치: "+team.getPitcherCoach());
		System.out.println("대표팀 타자: "+team.getHitter());
		System.out.println("대표팀 투수: "+team.getManager());
		
		//컨테이너를 썼으면 다시 닫자.
		ctx.close();
	}

		
		  
	}




