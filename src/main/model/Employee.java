package model;


public abstract class Employee {
    protected String name;
    protected String indent = "     ";

    public Employee(String name) {
        this.name = name;
    }

    public void print() {
        print(0);
    }

    public abstract void print(int i);

    public void printIndent(int indent) {
        String indentation = "     ";
        for (int i = 0; i < indent; i++) {
            indentation = indentation + ">>>>";
        }
        System.out.println(indentation);
    }

    public void createLineBreak() {
        System.out.println(">>>");
    }


}
