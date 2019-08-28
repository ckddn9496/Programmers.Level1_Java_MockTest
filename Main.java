import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
//		int[] answers = {1,3,2,4,2};
//		int[] answers = {3,3,2,3,2};
//		int[] answers = {6,6,6,6,6,6,6,6};
		
		System.out.println(Arrays.toString(new Solution().solution(answers)));
	}

}
class Solution {
	private int[] s1 = {1,2,3,4,5};
	private int[] s2 = {2,1,2,3,2,4,2,5};
	private int[] s3 = {3,3,1,1,2,2,4,4,5,5};
	
	public int[] solution(int[] answers) {
		int[] result = {};
		int[] indices = new int[3];
		int[] scores = new int[3];
		
		for (int i = 0; i < answers.length; i++) {
			int answer = answers[i];
			if (s1[indices[0]] == answer)
				scores[0]++;
			if (s2[indices[1]] == answer)
				scores[1]++;
			if (s3[indices[2]] == answer)
				scores[2]++;
			indices[0] = (indices[0]+1)%s1.length;
			indices[1] = (indices[1]+1)%s2.length;
			indices[2] = (indices[2]+1)%s3.length;
		}
		int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
		int count = 0;
		for (int i = 0; i < scores.length; i++)
			if (max == scores[i]) count++;
		result = new int[count];
		int idx = 0;
		for (int i = 0; i < scores.length; i++)
			if (max == scores[i]) result[idx++] = i+1;
		
		
//        Student[] students = new Student[3];
//        students[0] = new Student(1, s1);
//        students[1] = new Student(2, s2);
//        students[2] = new Student(3, s3);
//        
//        students[0].computeScore(answers);
//        students[1].computeScore(answers);
//        students[2].computeScore(answers);
        
//        Arrays.sort(students);
//        for (int i = 1; i < students.length; i++) {
//        	if (students[0].getScore() > students[i].getScore()) {
//        		result = new int[i];
//        		break;
//        	}
//        		
//        	if (i == students.length - 1)
//        		result = new int[students.length];
//        }
//        for (int i = 0; i < result.length; i++) {
//        	result[i] = students[i].getName();
//        }
        return result;
    }
//    class Student implements Comparable<Student> {
//    	private int name;
//    	private int[] patterns;
//    	private int index;
//    	private int score;
//    	
//    	public Student(int name, int[] patterns) {
//    		this.name = name;
//    		this.patterns = patterns;
//    		this.index = 0;
//    		this.score = 0;
//    	}
//    	
//    	public void computeScore(int[] answers) {
//    		for (int i = 0; i < answers.length; i++) {
//            	int answer = answers[i];
//            	if (patterns[index] == answer)
//            		score++;
//            	index = (index+1)%s1.length;
//            }
//    	}
//    	
//    	public int getName() {
//    		return this.name;
//    	}
//    	public int getScore() {
//    		return this.score;
//    	}
//    	
//    	@Override
//    	public String toString() {
//    		return this.name + " :" + this.score + "점";
//    	}
//    	
//		@Override
//		public int compareTo(Student s) {
//			if (s.getScore() == this.score)
//				return this.name - s.getName();
//			return s.getScore() - this.score;
//		}
//    	
//    	
//    }
}