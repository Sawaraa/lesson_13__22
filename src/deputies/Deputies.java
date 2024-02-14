package deputies;


import static java.lang.Integer.compare;

public class Deputies extends Human implements Comparable<Deputies> {
    private String lastName;
    private String firstName;
    private boolean bride;
    private int sizeOfTheBride;

    public Deputies() {
    }

    public Deputies(String lastName, String firstName, int weight, int height, boolean bride) {
        super();
        this.weight = weight;
        this.height = height;
        this.lastName = lastName;
        this.firstName = firstName;
        this.bride = bride;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isBride() {
        return bride;
    }

    public void setBride(boolean bride) {
        this.bride = bride;
    }

    public int getSizeOfTheBride() {
        return sizeOfTheBride;
    }

    public void setSizeOfTheBride(int sizeOfTheBride) {
        this.sizeOfTheBride = sizeOfTheBride;
    }

    @Override
    public String toString() {
        return String.format("Прізвище: %s, Ім'я: %s, Вага: %s, Ріст: %s",
                lastName, firstName, weight, height);
    }

    public void giveBride(int amount) {
        if (!bride) {
            System.out.println("Депутат " + lastName + " " + firstName + " не бере хабарів");
        } else {
            if (amount > 5000) {
                System.out.println("Поліція ув`язнить депутата - " + lastName + " " + firstName);
            } else {
                sizeOfTheBride = amount;
                System.out.println("Хабар внесено: " + sizeOfTheBride);
            }
        }

    }


    @Override
    public int compareTo(Deputies o) {
        return compare(this.getSizeOfTheBride(), o.getSizeOfTheBride());
    }

}
