public class Payroll {
    // double brace initialization
    // public static java.util.ArrayList<Integer> employeeIds = new java.util.ArrayList<>(){{add(5658845); add(4520125); add(7895122); add(8777541); add(8451277); add(1302850); add(7580489);}};

    // Arrays.asList initialization
    public static java.util.ArrayList<Integer> employeeIds = new java.util.ArrayList<>(java.util.Arrays.asList(5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489));

    // initialization via function returning object
    //public static java.util.ArrayList<Integer> employeeIds = newEmployeeIdArrayList();

    // pass ArrayList to be filled with employee ids
    //public static java.util.ArrayList<Integer> employeeIds = fillEmployeeIdArrayList(new java.util.ArrayList<>(0));

    private java.util.ArrayList<Employee> employees;

    public Payroll() {
        this.employees = new java.util.ArrayList<>(0);
        for (int x = 0; x < employeeIds.size(); x++) {
            this.employees.add(new Employee(employeeIds.get(x), 0, 6, 0));
        }
    }

    public Employee getEmployee(Integer id) {
        return this.employees.get(employeeIds.indexOf(id));

    }

    public static java.util.ArrayList<Integer> newEmployeeIdArrayList() {
        java.util.ArrayList<Integer> temp = new java.util.ArrayList<>(0);
        temp.add(5658845);
        temp.add(4520125);
        temp.add(7895122);
        temp.add(8777541);
        temp.add(8451277);
        temp.add(1302850);
        temp.add(7580489);
        return temp;
    }

    public static java.util.ArrayList<Integer> fillEmployeeIdArrayList(java.util.ArrayList<Integer> eIds) {
        eIds.add(5658845);
        eIds.add(4520125);
        eIds.add(7895122);
        eIds.add(8777541);
        eIds.add(8451277);
        eIds.add(1302850);
        eIds.add(7580489);
        return eIds;
    }
}
