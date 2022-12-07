/* Algorithms examples
 * 
 * 10/16/2017
 * Derrick Stone
 */
import java.util.Random;

public class Employee {
	/* codeforcoin.com maintains a database of developers for hire
	 * by keeping a data set of productivity, developers can be ranked
	 * and offered
	 * at a rate commensurate with their delivered value, calculated for each job
	 */
	private int employeeId;
	private int linesOfCode;
	private double hoursBilled;
	private int bugCount;
	private char qualityGrade;
	private int quantityRanking;
	private double valueRanking;
	
	
	public Employee(int emplid, boolean generate) {
		Random r = new Random();
		employeeId = emplid;
		linesOfCode = r.nextInt(10000);
		hoursBilled = r.nextInt(2080);
		bugCount = r.nextInt(100);
		
	}
	public Employee(Employee e) {
		
		employeeId = e.employeeId;
		linesOfCode = e.linesOfCode;
		hoursBilled = e.hoursBilled;
		bugCount = e.bugCount;
		qualityGrade = e.qualityGrade;
		quantityRanking=e.quantityRanking;
		valueRanking=e.valueRanking;
	}
	
	public String toString() {
		return "id "+employeeId+" LOC:"+linesOfCode+" hours:"+hoursBilled+" bugs:"+bugCount+" quality:"+qualityGrade+" quantity:"+ quantityRanking+" value:"+valueRanking;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getLinesOfCode() {
		return linesOfCode;
	}
	public void setLinesOfCode(int linesOfCode) {
		this.linesOfCode = linesOfCode;
	}
	public double getHoursBilled() {
		return hoursBilled;
	}
	public void setHoursBilled(double hoursBilled) {
		this.hoursBilled = hoursBilled;
	}
	public int getBugCount() {
		return bugCount;
	}
	public void setBugCount(int bugCount) {
		this.bugCount = bugCount;
	}
	public char getQualityGrade() {
		return qualityGrade;
	}
	public void setQualityGrade(char qualityGrade) {
		this.qualityGrade = qualityGrade;
	}
	public int getQuantityRanking() {
		return quantityRanking;
	}
	public void setQuantityRanking(int quantityRanking) {
		this.quantityRanking = quantityRanking;
	}
	public double getValueRanking() {
		return valueRanking;
	}
	public void setValueRanking(double valueRanking) {
		this.valueRanking = valueRanking;
	}

	

}
