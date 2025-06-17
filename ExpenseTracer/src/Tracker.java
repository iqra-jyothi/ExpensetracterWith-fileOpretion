import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Tracker {
    public void addexpense(ArrayList<Expense> al, Scanner sc) {
        System.out.print("Enter date (dd-MM-yyyy): ");
        String Date = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(Date, formatter);
            System.out.println("Formatted date: " + date);
            System.out.println("enter the category");
            String category = sc.next();
            sc.nextLine();
            System.out.println("enter the Description");
            String desp = sc.next();
            sc.nextLine();
            System.out.println("enter the amount");
            double amount = sc.nextDouble();
            Expense ex = new Expense(date, category, desp, amount);
            al.add(ex);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
    }

    public void viewallexpenses(ArrayList<Expense> al) {
        if (al.isEmpty()) {
            System.out.println("empty no list of expenses");
        } else {
            for (Expense e : al) {
                System.out.println(e);

            }
        }
    }

    public void viewAllExpensesSpecificDate(ArrayList<Expense> al, Scanner sc) {
        System.out.print("Enter date (dd-MM-yyyy): ");
        String Date = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(Date, formatter);
            System.out.println("Formatted date: " + date);
            for (Expense e : al) {
                if (e.getDate().equals(date)) {
                    System.out.println(e);
                } else {
                    System.out.println("not expense no this date " + date);
                }
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
    }

    public void ViewAllFromtoToexpeses(ArrayList<Expense> al, Scanner sc) {
        System.out.print("Enter date from (dd-MM-yyyy): ");
        String from = sc.next();
        System.out.print("Enter date To (dd-MM-yyyy): ");
        String to = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate From = LocalDate.parse(from, formatter);
            System.out.println("Formatted date: " + From);
            LocalDate To = LocalDate.parse(to, formatter);
            System.out.println("Formatted date: " + To);
            for (LocalDate d = From; !d.isAfter(To); d = d.plusDays(1)) {
                Boolean found = false;
                for (Expense e : al) {
                    if (e.getDate().equals(d)) {
                        System.out.println(e);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No expenses on " + d);
                }

            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
    }

    public void DeleteSpecificdate(ArrayList<Expense> al, Scanner sc) {
        System.out.print("Enter date  to delete (dd-MM-yyyy): ");
        String Date = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(Date, formatter);
            System.out.println("Formatted date: " + date);
            boolean found = false;
            Iterator<Expense> itr = al.iterator();
            while (itr.hasNext()) {
                Expense e = itr.next();
                if (e.getDate().equals(date)) {
                    itr.remove(); // Safe way to remove
                    System.out.println("Successfully removed: " + e);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No expense found for the given date and category.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }

    }

    public void DeleteAll(ArrayList<Expense> al) {
        if (al.isEmpty()) {
            System.out.println("no item to delete");
        } else {
            al.clear();
            System.out.println("cleared all item");
        }
    }

    public void DeleteSpecificdateandcretory(ArrayList<Expense> al, Scanner sc) {
        System.out.print("Enter date  to delete (dd-MM-yyyy): ");
        String Date = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(Date, formatter);
            System.out.println("Formatted date: " + date);
            System.out.println("enter the category");
            String category = sc.next();
            sc.nextLine();
            boolean found = false;
            Iterator<Expense> itr = al.iterator();
            while (itr.hasNext()) {
                Expense e = itr.next();
                if (e.getDate().equals(date) && e.getCategory().equals(category)) {
                    itr.remove(); // Safe way to remove
                    System.out.println("Successfully removed: " + e);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No expense found for the given date and category.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
    }

    public double TotalExpenseSpecificDate(ArrayList<Expense> al, Scanner sc) {
        System.out.print("Enter date  to delete (dd-MM-yyyy): ");
        String Date = sc.next();
        double sum = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(Date, formatter);
            System.out.println("Formatted date: " + date);
            boolean found = false;
            Iterator<Expense> itr = al.iterator();
            while (itr.hasNext()) {
                Expense e = itr.next();
                if (e.getDate().equals(date) ) {
                 sum+= e.getAmount();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No expense found for the given date and category.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
        return sum;
    }

    public double TotalFromTo(ArrayList<Expense> al, Scanner sc) {
        double sum = 0;
        System.out.print("Enter date from (dd-MM-yyyy): ");
        String from = sc.next();
        System.out.print("Enter date To (dd-MM-yyyy): ");
        String to = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate From = LocalDate.parse(from, formatter);
            System.out.println("Formatted date: " + From);
            LocalDate To = LocalDate.parse(to, formatter);
            System.out.println("Formatted date: " + To);
            for (LocalDate d = From; !d.isAfter(To); d = d.plusDays(1)) {
                Boolean found = false;
                Iterator<Expense>itr= al.iterator() ;
                while (itr.hasNext())
                {
                    Expense e= itr.next();
                    if (e.getDate().equals(d)) {
                        sum += e.getAmount();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No expenses on " + d);
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
        return sum;
    }

    public double totalcetogarydate(ArrayList<Expense> al, Scanner sc) {
        double sum=0;
        System.out.print("Enter date  to delete (dd-MM-yyyy): ");
        String Date = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(Date, formatter);
            System.out.println("Formatted date: " + date);
            System.out.println("enter the category");
            String category = sc.next();
            sc.nextLine();
            boolean found = false;
            Iterator<Expense> itr = al.iterator();
            while (itr.hasNext()) {
                Expense e = itr.next();
                if (e.getDate().equals(date) && e.getCategory().equals(category)) {
                sum+= e.getAmount();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No expense found for the given date and category.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid format. Use dd-MM-yyyy.");
        }
        return sum;
    }

    public void printallExpenses(ArrayList<Expense> al) {
        if (al.isEmpty()) {
            System.out.println("No expenses to print.");
        } else {
            System.out.println("All Expenses:");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("expense.txt"));
                for (Expense e : al) {
                    writer.write(e.toString());
                    writer.newLine();
                }
                writer.close();
            }catch (Exception e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    public void readtiledata(ArrayList<Expense> al) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            BufferedReader br=new BufferedReader(new FileReader("read.txt"));
            String line;
            while ((line=br.readLine())!=null)

            {
                String[]data=line.split(",");
                LocalDate date = LocalDate.parse(data[0], formatter);
                String category = data[1];
                String desc=data[2];
                double amount= Double.parseDouble(data[3]);
                Expense ex = new Expense(date, category, desc, amount);
                al.add(ex);

            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public void viewCategoryWiseTotal(ArrayList<Expense> al) {
      Map<String,Double>categorytotal=new HashMap<>();
      for(Expense e:al)
      {
          String category=e.getCategory();
          double amount=e.getAmount();
          categorytotal.put(category,categorytotal.getOrDefault(category,0.0)+amount);
      }
      if(categorytotal.isEmpty())
      {
          System.out.println("no expenses to view category wise total");
      }
      else {
          System.out.println("Category Wise Total:");
          for (Map.Entry<String, Double> entry : categorytotal.entrySet()) {
              System.out.println("Category: " + entry.getKey() + ", Total: " + entry.getValue());
          }
      }
    }

    public void viewSortedByAmount(ArrayList<Expense> al) {
        if (al.isEmpty()) {
            System.out.println("No expenses to sort.");
            return;
        }
        al.sort(Comparator.comparingDouble(Expense::getAmount));
        System.out.println("Expenses sorted by amount:");
        for (Expense e : al) {
            System.out.println(e);
        }
    }
}
