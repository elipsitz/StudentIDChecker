package com.aegamesi.studentidchecker.models;

import io.realm.RealmObject;

public class RoomAssignmentCondition extends RealmObject {
	public String key;
	public String op;
	public long val;

	public boolean evaluate(Student student) {
		long operand = 0;
		switch (key) {
			case "sid":
				operand = student.studentId;
				break;
			case "sid_mod100":
				operand = student.studentId % 100;
				break;
			case "section_dis":
				operand = student.sectionDis;
				break;
			case "section_lab":
				operand = student.sectionLab;
				break;
			case "section_lec":
				operand = student.sectionLec;
				break;
		}

		switch (op) {
			case "==":
				return operand == val;
			case "<":
				return operand < val;
			case ">":
				return operand > val;
			case "<=":
				return operand <= val;
			case ">=":
				return operand >= val;
			case "!=":
				return operand != val;
		}

		return false;
	}
}