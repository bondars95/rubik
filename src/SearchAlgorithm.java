import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * A star algorithm implementation.
 */
public final class SearchAlgorithm {
    /*
	 * All attainable corner states of a rubik's cube.
	 * There are 8! * 3^7 = 88,179,840 possible combination.
	 */
    public static final int[] corners = readHeuristics(88179840, "bin/corners.csv");
    /*
     * Half of all attainable edge states of a  rubik's cube.
     * There are 12!/6! * 2^6 = 42,577,920 possible combinations.
     */
    public static final int[] edgesSetOne = readHeuristics(42577920, "bin/edgesSetOne.csv");
    /*
     * Second half of all attainable edge states of a  rubik's cube.
     * There are 12!/6! * 2^6 = 42,577,920 possible combinations.
     */
    public static final int[] edgesSetTwo = readHeuristics(42577920, "bin/edgesSetTwo.csv");
    public static int nextBound;
    public static int nodesVisited;
    public PriorityQueue<CubeNode> frontier = new PriorityQueue<CubeNode>();
    public HashSet<CubeNode> explored = new HashSet<CubeNode>();
    public Rotation[] movements = Rotation.values();

    /**
     * Root node.
     */
    private final  CubeNode root;
    /**
     * List of visited nodes to visit.
     */
    private final PriorityQueue<CubeNode> openNodes;
    /**
     * List of visited nodes.
     */
    private final HashMap<char[], CubeNode> closedNodes;
    /**
     * Final path.
     */
    private final List<CubeNode> path;


    public SearchAlgorithm(char[] startState) {
        // comparator for sorting nodes based on its cost
        this.openNodes = new PriorityQueue<CubeNode>();
        this.closedNodes = new HashMap<>();
        this.path = new ArrayList<>();
        this.root = new CubeNode(startState, corners[Integer.parseInt(Cube.encodeCorners(startState))]);
    }

    /**
     * Performs search of final path.
     */
    public void search() {
        openNodes.add(root);
        int openNodesMax = 0;
        while (!openNodes.isEmpty() && path.isEmpty()) {
            CubeNode n = openNodes.poll();
            if (closedNodes.containsKey(n.state)) {
                continue;
            }
            if (n.heuristic == 0) {
                System.out.println(n.path);
            }
            closedNodes.put(n.state, n);
            for (Rotation rotation:  Rotation.mapping.values()) {
                if (rotation == Rotation.REVERSE_FRONT) {
                    System.out.println();
                }
                char[] res = Cube.rotate(
                        n.state,
                        Cube.NOTATION_TO_FACES.get(rotation.getNotation()),
                        rotation.getTurns()
                );
                openNodes.add(
                        new CubeNode(
                                res,
                                corners[Integer.parseInt(Cube.encodeCorners(res))],
                                n.path + " " + Rotation.mapping.get(rotation)
                        )
                );
            }
            openNodesMax = openNodes.size() > openNodesMax ? openNodes.size() : openNodesMax;
        }
    }

    /**
     * Reads the CSV files for the heuristics and returns an int[]
     * where the values are the heuristic values
     * @param h the size of the array
     * @param fileName the name of the CSV file to read from
     * @return an int[]
     */
    private static int[] readHeuristics(int h, String fileName) {
        // Our corners heuristics array will have 88179840
        // elements, but not all of them will have a value
        // as we only calculated heuristics for valid corner
        // positions starting at the goal state rather than
        // all possible permutations of corners.
        int[] heuristics = new int[h];
        FileReader file = null;
        String line;
        try {
            file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            while ((line = reader.readLine()) != null) {
                // For each line, split by the comma
                String[] lineData = line.split(",");
                // lineData[0] will be the encoded corner value
                // lineData[1] will be the calculated heuristic
                if (!(lineData[0].equals("") || lineData[1].equals(""))) {
                    if (Integer.parseInt(lineData[0]) == 0) {
                        System.out.println();
                    }
                    heuristics[Integer.parseInt(lineData[0])] = Integer.parseInt(lineData[1]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IO error occurred");
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return heuristics;
    }
}
