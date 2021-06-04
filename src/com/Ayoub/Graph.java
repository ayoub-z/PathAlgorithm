package com.Ayoub;


import java.util.*;

class Graph {

    // source: https://github.com/mburst/dijkstras-algorithm/blob/master/Dijkstras.java

    private final Map<Character, List<Step>> Steps;

    public Graph() {
        this.Steps = new HashMap<Character, List<Step>>();
    }

    public void addStep(Character character, List<Step> node) {
        this.Steps.put(character, node);
    }

    public Map<Character, List<Step>> getSteps() {
        return Steps;
    }

    public List<Character> getShortestPath(Character start, Character end) {
        final Map<Character, Integer> distances = new HashMap<Character, Integer>();
        final Map<Character, Step> previous = new HashMap<Character, Step>();
        PriorityQueue<Step> steps = new PriorityQueue<Step>();

        for (Character step : Steps.keySet()) {
            if (step == start) {
                distances.put(step, 0);
                steps.add(new Step(step, 0));
            } else {
                distances.put(step, Integer.MAX_VALUE);
                steps.add(new Step(step, Integer.MAX_VALUE));
            }
            previous.put(step, null);
        }

        while (!steps.isEmpty()) {
            Step smallest = steps.poll();
            if (smallest.getId() == end) {
                final List<Character> path = new ArrayList<Character>();
                while (previous.get(smallest.getId()) != null) {
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }

                // since it returns the path starting from the endpoint, we need to reverse it
                Collections.reverse(path);
                return path;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }

            for (Step nextNode : Steps.get(smallest.getId())) {
                Integer alt = distances.get(smallest.getId()) + nextNode.getDistance();
                if (alt < distances.get(nextNode.getId())) {
                    distances.put(nextNode.getId(), alt);
                    previous.put(nextNode.getId(), smallest);
                    for (Step n : steps) {
                        if (n.getId() == nextNode.getId()) {
                            steps.remove(n);
                            n.setDistance(alt);
                            steps.add(n);
                            break;
                        }
                    }
                }
            }
        }

        ArrayList<Character> a = new ArrayList<Character>(distances.keySet());
        Collections.reverse(a);
        return a;
    }

    public String toString(List<Character> path) {
        return "The shortest path is: " + path;
    }
}
