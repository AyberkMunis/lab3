package diet;

public class rawmat implements NutritionalElement{

    public String name;
	public double calories;
	public double proteins;
	public double carbs;
	public double fat;
    public boolean per100g;
    public rawmat(String name, double calories, double proteins, double carbs, double fat) {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fat = fat;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCalories() {
        return calories;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public double getProteins() {
        return proteins;
    }
    public void setProteins(double proteins) {
        this.proteins = proteins;
    }
    public double getCarbs() {
        return carbs;
    }
    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
    public double getFat() {
        return fat;
    }
    public void setFat(double fat) {
        this.fat = fat;
    }
    @Override
    public boolean per100g() {
        return true;
    }
    

    

}
