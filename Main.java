package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("---------- Choice -----------" + "\n\t1.insertData" + "\n\t2.readData"
						+ "\n\t3.updateData" + "\n\t4.deleteData" + "\n\t5.exitApp" + "\n Enter the choice :");

				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					System.out.println("Enter the eId :");
					String eId = sc.nextLine();
					System.out.println("Enter the eName");
					String eName = sc.nextLine();
					System.out.println("Enter the eDesg");
					String eDesg = sc.nextLine();
					System.out.println("Enter the eSal");
					double eSal = Double.parseDouble(sc.nextLine());

					Employee e = new Employee();
					e.seteId(eId);
					e.seteName(eName);
					e.seteDesg(eDesg);
					e.seteSal(eSal);
					int k = new EmployeeCurdDAO().insertData(e);
					System.out.println("Data inserted Successfully....!");

					break;
				case 2:
					ArrayList<Employee> al = new EmployeeCurdDAO().readData();
					al.forEach((l) -> {
						System.out.println(l);
					});

					break;
				case 3:
					System.out.println("Enter the eId :");
					String id = sc.nextLine();
					System.out.println("Enter the eName");
					String Name = sc.nextLine();
					System.out.println("Enter the eDesg");
					String Desg = sc.nextLine();
					System.out.println("Enter the eSal");
					double Sal = Double.parseDouble(sc.nextLine());

					Employee e1 = new Employee();
					e1.seteId(id);
					e1.seteName(Name);
					e1.seteDesg(Desg);
					e1.seteSal(Sal);
					int k1 = new EmployeeCurdDAO().updateData(e1);
					if (k1 > 0) {
						System.out.println("Data updated Successfully....!");
					} else {
						System.out.println("empployee id not not there.....! ");
					}

					break;
				case 4:
					System.out.println("Enter the eid");
					String eID = sc.nextLine();

					int k2 = new EmployeeCurdDAO().deleteData(eID);

					if (k2 > 0) {
						System.out.println("Data deleted Successfully....!");
					} else {
						System.out.println("Details not Available");
					}

					break;
				case 5:
					System.out.println("Application execution completed.....!");
					System.exit(1);
					break;
					
				case 6:
					ArrayList<Employee> ob=new EmployeeCurdDAO().sort();
					
					ob.forEach((s)->{
						System.out.println(s);
					});
					break;
				default:
					System.out.println("invalid choice  Enter only 1-5 values....!");
				}
			}
		} catch (Exception e) {
			System.out.println("Enter only Integer Data.....!");
		}

	}

}
