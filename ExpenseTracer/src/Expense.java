import java.time.LocalDate;

public class Expense {
    private LocalDate Date;
    private  String category;
    private String description;
    private  Double amount;

    public Expense( LocalDate Date , String category, String description, Double amount) {

        this.Date = Date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }


    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate  Date) {
        this.Date = Date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +

                ", Date='" + Date + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}

