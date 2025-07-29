package HomeWorks.HomeWork08;

import java.time.LocalDate;

public class DiscountProduct extends Product {

    private double discount;
    private LocalDate validUntil;

    public DiscountProduct(String name, double baseCost, double discount, LocalDate validUntil) {
        super(name, baseCost);
        setDiscount(discount);
        setValidUntil(validUntil);
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%");
        }
        this.discount = discount;
    }

    public void setValidUntil(LocalDate validUntil) {
        if (validUntil == null) {
            throw new IllegalArgumentException("Дата окончания скидки обязательна");
        }
        this.validUntil = validUntil;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    @Override
    public double getCost() {
        if (LocalDate.now().isAfter(validUntil)) {
            return super.getCost(); // Скидка истекла
        }
        double discountedPrice = super.getCost() * (1 - discount / 100);
        return Math.max(discountedPrice, 0); // Гарантируем неотрицательность
    }
}
