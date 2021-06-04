package com.Ayoub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
		Ride ride = new Ride();

		ride.addStep('A', Arrays.asList(new Step('B', 10), new Step('C', 15)));
		ride.addStep('B', Arrays.asList(new Step('D', 2), new Step('E', 15)));
		ride.addStep('C', Arrays.asList(new Step('F', 100), new Step('E', 50)));
		ride.addStep('D', Arrays.asList(new Step('F', 2), new Step('E', 1)));
		ride.addStep('E', Collections.singletonList(new Step('F', 20)));
		ride.addStep('F', Arrays.asList(new Step('D', 2), new Step('E', 20), new Step('C', 100)));

		List<Character> carPath = ride.getShortestPath('A', 'F');
		System.out.println(ride.toString(carPath));

	}
}
