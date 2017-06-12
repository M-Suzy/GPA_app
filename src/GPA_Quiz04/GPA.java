package GPA_Quiz04;
import java.util.Scanner;

public class GPA {
	public static double points(String grade){ 
	String letters[] = {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F","I","W"};
	double values[] = {4.0, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0, -1, -1};
	for(int i = 0; i < letters.length; i++){
		if(grade.equals(letters[i])) return values[i];
		}
		return -4;
	}
	public static int maxValueSem(int[] semester) { //max value from semester code inputs
		int max = semester[0];
		for (int i = 1; i < semester.length; i++) {
			if (semester[i] > max) max = semester[i];
			}
		return max;
	} 
	  
public static double[] gpa(int[] semester, int[] count, int[] credits, double[] grade){
		double[] gpa = new double[count.length]; 
		double  sum_credits = 0, previous = 0;
		for(int i = 0; i < gpa.length; i++){ 
			double  current = 0;
			for(int j =0; j < semester.length; j++){
				if(semester[j] == i){
					current += grade[j] * credits[j];
					sum_credits += credits[j];
				}
			}
			previous += current;
			previous /= sum_credits;
			gpa[i] = previous;
		}
		return gpa;
	} 
	public static void main(String[] args){   
		Scanner input = new Scanner(System.in);
		int courses = input.nextInt();        
		double grade[] = new double[courses]; 
		int credits[] = new int[courses];    
		int semester[] = new int[courses];    
		for(int i = 0; i < courses; i++){    
			grade[i] = points(input.next());  
			credits[i] = input.nextInt();
			semester[i] = input.nextInt();
		}
		input.close();
		
		int size = maxValueSem(semester)+1;
		int[] count = new int[size];         
		
		for(int i = 0; i < semester.length; i++){
			count[semester[i]]++;
		}      
  double gpa[] = gpa(semester, count, credits, grade); 
		for (int i=0; i<gpa.length; i++)          
		System.out.print(gpa[i]);
	}
}
      

