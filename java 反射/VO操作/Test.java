package VO;

public class Test {
    public static void main(String[] args) throws Exception {
        String value = "emp.name:yuisama|emp.job:Java Coder";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}