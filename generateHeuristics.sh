# Compile all of the java files
# Run the Heuristics generation class and pipe the
# output into a csv file
cd bin
echo "Generate Corner heuristics..."
java CornerHeuristics -Xmx2048M > corners.csv;
# Generate the first set of edge heuristics and pipe
# the output into a csv file
echo "Generate Edge Set One heuristics..."
java EdgeHeuristics 0 -Xmx2048M > edgesSetOne.csv;
# Generate the second set of edge heuristics and pipe
# the output into a csv file
echo "Generate Edge Set Two heuristics..."
java EdgeHeuristics 1 -Xmx2048M > edgesSetTwo.csv;