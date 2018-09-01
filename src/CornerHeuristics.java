import java.util.*;


public class CornerHeuristics {
	/**
	 * As per Korf's paper, we should generate all of the permutations
	 * by starting with a solved cube and then performing a breadth-
	 * first search. Heuristic value is a path size from goal state to current/
	 */
	private static void generateCornerHeuristics() {
		// Make a cube and initialize it with a solved cube state
		Cube cube = new Cube(Cube.GOAL.toCharArray());

		// Make a new Queue to perform BFS
		Queue<CubeNode> q = new LinkedList<>();

		// Put the solved/initial state of the corners on the queue
		q.add(new CubeNode(cube.state, 0));
		// total number of possible combinations
		int[] corners = new int[88179840];
		Set<Character> faces = Cube.FACES.keySet();

		// Iterate until not empty
		while (!q.isEmpty()) {
			CubeNode current = q.poll();
			// Perform all possible movements for current node
			for (Character face : faces) {
				// Do a clockwise turn
				char[] newState = Cube.rotate(current.state, face, 1);
				// calculate state ID
				int encodedCorner = Integer.parseInt(Cube.encodeCorners(newState));
				// Check to see if this combination has been made before
				if (corners[encodedCorner] == 0) {
                    // This is a new combination, let's add it to the queue
					q.add(new CubeNode(newState, current.heuristic + 1));
				}
			}

			// Calculate state id, check if was made before
			String encodedCorner = Cube.encodeCorners(current.state);
			int encodedCornerInt = Integer.parseInt(encodedCorner);
			if (corners[encodedCornerInt] == 0) {
				corners[encodedCornerInt] = current.heuristic;
				// Print this out to stdin
				System.out.println(encodedCorner + "," + current.heuristic);
			}
		}
    }

	/**
	 * A main function to start heuristic table generation
	 */
	public static void main(String[] args) {
		CornerHeuristics.generateCornerHeuristics();
	}
}
