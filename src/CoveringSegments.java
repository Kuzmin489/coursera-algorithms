import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(List<Segment> segments) {
        //write your code here
        segments.sort(Comparator.comparingInt(o -> o.start));
        System.out.println(segments);
        List<Integer> points = new ArrayList<>();
        
        while (!segments.isEmpty()) {
            Segment segmentToCompare = segments.get(0);
            segments.remove(0);
            
            if(segments.isEmpty()) {
                points.add(segmentToCompare.end);
                break;
            }
            
            Segment nexSegment = segments.get(0);
            
        }
        return points;
    }
    
    private static int findCommonMostRighPoint(Segment first, Segment second) {
        return -1;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Segment> segments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(i, new Segment(start, end));
    
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
