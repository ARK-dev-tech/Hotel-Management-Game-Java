public class Guest {

    String name, country, expiry;
    int age, dayEnter;

    Guest(String name, int age, String country, String expiry, int dayEnter){
        this.name = name;
        this.age = age;
        this.country = country;
        this.expiry = expiry;
        this.dayEnter = dayEnter;
    }

    @Override
    public String toString() {
        return "{Name: '" + this.name + "', Age: '" + this.age + "', Country: '" + this.country + "', Expiry: '" + this.expiry + "', Day: " + this.dayEnter + "'}";
    }

}
