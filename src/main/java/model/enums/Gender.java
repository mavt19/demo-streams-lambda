package model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

	MALE(1L, "male"), FEMALE(2L, "female"), OTHER(3L, "other");
	private final Long id;
	private final String name;
	
	
}
