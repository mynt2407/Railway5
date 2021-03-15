package com.vti.frontend;

import java.util.List;

import com.vti.Enumerate.PositionName;
import com.vti.datalayer.PositionRepository;
import com.vti.entity.Position;


public class PositionTest {
	public static void main(String[] args) {

		PositionRepository positionRepository = new PositionRepository();

		System.out.println("***********GET ALL POSITION***********");
		List<Position> positions = positionRepository.getAllPosition(); 
		for (Position position : positions) {
			System.out.println(position);
		}
		
		
		System.out.println("\n\n***********CREATE POSITION ***********");
		Position position = new Position();
		position.setName(PositionName.PM);
		positionRepository.createPosition(position);

		
	}
}
