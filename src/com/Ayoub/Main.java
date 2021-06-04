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


		Flight flight = new Flight();

		// A = Amsterdam | B = Barcelona | R = Rome | L = London | C = Copenhagen | W = Warsaw
		// N = New York | M = Moscow | Z = Zimbabwe

		flight.addStep('A', Arrays.asList(new Step('B', 355), new Step('C', 350),new Step('M', 900)));
		flight.addStep('B', Collections.singletonList(new Step('R', 201)));
		flight.addStep('R', Collections.singletonList(new Step('N', 1850)));
		flight.addStep('C', Arrays.asList(new Step('R', 309), new Step('L', 1788)));
		flight.addStep('L', Arrays.asList(new Step('N', 1790), new Step('W', 670)));
		flight.addStep('M', Collections.singletonList(new Step('Z', 2081)));
		flight.addStep('Z', Collections.singletonList(new Step('W', 1455)));
		flight.addStep('W', Collections.singletonList(new Step('N', 2145)));
		flight.addStep('N', Collections.singletonList(new Step('W', 2145)));

		List<Character> flightPath = flight.getShortestPath('A', 'N');
		System.out.println(flight.toString(flightPath));
	}
}
